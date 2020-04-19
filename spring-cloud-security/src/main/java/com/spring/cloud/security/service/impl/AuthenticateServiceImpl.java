package com.spring.cloud.security.service.impl;

import com.spring.cloud.commons.constant.RedisConst;
import com.spring.cloud.commons.entity.JwtClaims;
import com.spring.cloud.commons.entity.RedisUser;
import com.spring.cloud.commons.result.Result;
import com.spring.cloud.commons.utils.JJwtHsUtils;
import com.spring.cloud.commons.utils.RedisUtils;
import com.spring.cloud.security.mybatisplus.entity.PlatformUser;
import com.spring.cloud.security.mybatisplus.service.IPlatformUserService;
import com.spring.cloud.security.service.AuthenticateService;
import com.spring.cloud.security.service.PlatformUserCommonService;
import org.jasypt.encryption.StringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

//@Service
public class AuthenticateServiceImpl implements AuthenticateService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticateServiceImpl.class);

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private StringEncryptor stringEncryptor;

    @Autowired
    private PlatformUserCommonService platformUserCommonService;

    @Autowired
    private IPlatformUserService platformUserService;

    @Override
    public Result register(PlatformUser registerUser) {
        String userId = registerUser.getUserId();

        // 检查用户是否已存在
        PlatformUser dbUser = platformUserCommonService.getPlatformUser(userId);
        if (!ObjectUtils.isEmpty(dbUser)) {
            return new Result(1, "用户已注册！", null);
        }

        String password = registerUser.getPassword();
        registerUser.setPassword(stringEncryptor.encrypt(password)); // 密码加密保存

        platformUserService.save(registerUser);

        return new Result(0, null, null);
    }

    @Override
    public Result login(PlatformUser loginUser) {
        logger.debug("登录 处理 开始");

        String tenantId = loginUser.getTenantId();
        String companyId = loginUser.getCompanyId();
        String userId = loginUser.getUserId();

        // 根据userId从数据库中获取用户信息
        PlatformUser dbUser = platformUserCommonService.getPlatformUser(userId);
        if (ObjectUtils.isEmpty(dbUser)) {
            logger.debug("登录 用户不存在！");
            return new Result(1, "用户不存在！", null);
        }

        logger.debug("登录 获取DB用户 成功");

        // 验证密码
        String loginPassword = loginUser.getPassword();
        String dbPassword = dbUser.getPassword();
        String decryptPassword = stringEncryptor.decrypt(dbPassword); // 解密DB密码
        if (!ObjectUtils.nullSafeEquals(loginPassword, decryptPassword)) {
            logger.debug("登录 用户名/密码不正确！");
            return new Result(1, "用户名/密码不正确！", null);
        }

        logger.debug("登录 密码验证 成功");

        // 密码验证通过，从Redis中获取用户登录uuid，若不存在，则生成登录uuid
        String loginUUID = redisUtils.getString(RedisConst.TOKEN_PREFIX_LOGIN_UUID + userId);
        if (StringUtils.isEmpty(loginUUID)) {
            loginUUID = UUID.randomUUID().toString();
        }

        redisUtils.setString(RedisConst.TOKEN_PREFIX_LOGIN_UUID + userId, loginUUID, 2, TimeUnit.HOURS);

        RedisUser redisUser = new RedisUser();
        BeanUtils.copyProperties(dbUser, redisUser);
        redisUtils.setObject(RedisConst.TOKEN_PREFIX_USER_INFO + userId, redisUser, 2, TimeUnit.HOURS);

//        String token = JJwtRsaAlgorithmsUtils.creatJWS(tenantId, userId, loginUUID); // 该算法耗时较长 大约12m
        String token = JJwtHsUtils.creatJWS(new JwtClaims(tenantId, companyId, userId, loginUUID));
        logger.debug("登录 成功 token: {}", token);

        logger.debug("登录 处理 结束");
        return new Result(0, null, token);
    }

    @Override
    public Result logout(String loginUserId) {
        logger.debug("退出 清除Redis中用户数据 开始");
        redisUtils.setString(RedisConst.TOKEN_PREFIX_LOGIN_UUID + loginUserId, "null", 1, TimeUnit.MILLISECONDS);
        redisUtils.setString(RedisConst.TOKEN_PREFIX_USER_INFO + loginUserId, "null", 1, TimeUnit.MILLISECONDS);
        logger.debug("退出 清除Redis中用户数据 结束");
        return new Result(0, null, null);
    }
}
