package com.spring.cloud.security.service.impl;

import com.spring.cloud.commons.constant.RedisConst;
import com.spring.cloud.commons.dto.LoginDto;
import com.spring.cloud.commons.dto.RegisterDto;
import com.spring.cloud.commons.entity.RedisUser;
import com.spring.cloud.commons.result.Result;
import com.spring.cloud.security.service.AuthenticateService;
import com.spring.cloud.web.commons.utils.RedisUtils;
import org.jasypt.encryption.StringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Result register(RegisterDto registerDto) {
        String username = registerDto.getUsername();

        // 检查用户是否已存在

        String password = registerDto.getPassword();
//        registerUser.setPassword(stringEncryptor.encrypt(password)); // 密码加密保存

        // 保存用户

        return new Result(0, null);
    }

    @Override
    public Result login(LoginDto loginDto) {
        logger.debug("登录 处理 开始");

        String username = loginDto.getUsername();

        // 1. 根据 username 从Redis中获取用户信息

        // 2. Redis中不存在该用户信息时，根据 username 从数据库中获取用户信息

        logger.debug("登录 获取DB用户 成功");

        // 3. 验证密码
//        String decryptPassword = stringEncryptor.decrypt(dbPassword); // 解密DB密码

        logger.debug("登录 密码验证 成功");

        // 4. 密码验证通过，从Redis中获取用户登录uuid，若不存在，则生成登录uuid
        String loginUUID = redisUtils.getString(RedisConst.TOKEN_PREFIX_LOGIN_UUID + username);
        if (StringUtils.isEmpty(loginUUID)) {
            loginUUID = UUID.randomUUID().toString();
        }

        redisUtils.setString(RedisConst.TOKEN_PREFIX_LOGIN_UUID + username, loginUUID, 2, TimeUnit.HOURS);

        RedisUser redisUser = new RedisUser();
//        BeanUtils.copyProperties(dbUser, redisUser);
        redisUtils.setObject(RedisConst.TOKEN_PREFIX_USER_INFO + username, redisUser, 2, TimeUnit.HOURS);

//        String token = JJwtRsaAlgorithmsUtils.creatJWS(tenantId, userId, loginUUID); // 该算法耗时较长 大约12m
//        String token = JJwtHsUtils.creatJWS(new JwtClaims(tenantId, companyId, username, loginUUID));
        String token = "";
        logger.debug("登录 成功 token: {}", token);

        logger.debug("登录 处理 结束");
        return new Result(0, null, token);
    }

    @Override
    public Result logout(String loginUserId) {
        logger.debug("退出 清除Redis中用户数据 开始");
        redisUtils.deleteString(RedisConst.TOKEN_PREFIX_LOGIN_UUID + loginUserId);
        redisUtils.deleteString(RedisConst.TOKEN_PREFIX_USER_INFO + loginUserId);

        logger.debug("退出 清除Redis中用户数据 结束");
        return new Result(0, null);
    }
}
