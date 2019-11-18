package com.spring.cloud.security.utils;

import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.security.constant.TokenConstant;
import com.spring.cloud.security.entity.RedisPlatformUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateUtilsTest {
    @Autowired
    private RedisTemplateUtils redisTemplateUtils;

    @Test
    public void set() {
        String key = "age";
        String value = "10";
        redisTemplateUtils.setString(key, value);

        redisTemplateUtils.increment(key, 20);

        System.out.println(redisTemplateUtils.getString(key));
    }

    @Test
    public void setObject() {
        RedisPlatformUser loginUser = new RedisPlatformUser();
        loginUser.setTenantId("tenant_000001");
        loginUser.setUserId("user_000001");

        redisTemplateUtils.setObject("login_user", loginUser);
        System.out.println(redisTemplateUtils.getObject("login_user", RedisPlatformUser.class));
    }

    @Test
    public void setList() {
        List<RedisPlatformUser> loginUserList = new ArrayList<>();

        RedisPlatformUser loginUser = new RedisPlatformUser();
        loginUser.setTenantId("tenant_000001");
        loginUser.setUserId("user_000001");
        loginUserList.add(loginUser);

        loginUser = new RedisPlatformUser();
        loginUser.setTenantId("tenant_000002");
        loginUser.setUserId("user_000002");
        loginUserList.add(loginUser);

        loginUser = new RedisPlatformUser();
        loginUser.setTenantId("tenant_000003");
        loginUser.setUserId("user_000003");
        loginUserList.add(loginUser);

        redisTemplateUtils.setList("login_user_list", loginUserList);
        System.out.println(redisTemplateUtils.getList("login_user_list", RedisPlatformUser.class));
    }

    @Test
    public void login() {
        for (int i = 1; i < 3; i++) {
            String userId = "user_00000" + i;
            String loginUUID = UUID.randomUUID().toString();
            RedisPlatformUser dbUser = new RedisPlatformUser();
            dbUser.setTenantId("tenant_00000" + i);
            dbUser.setUserId(userId);

            redisTemplateUtils.setString(TokenConstant.REDIS_TOKEN_PREFIX_LOGIN_UUID + userId, loginUUID, 2, TimeUnit.HOURS);
            redisTemplateUtils.setObject(TokenConstant.REDIS_TOKEN_PREFIX_USER_INFO + userId, dbUser, 2, TimeUnit.HOURS);
        }
    }

    @Test
    public void request() {
        String userId = "user_000001";
        String loginUUID = redisTemplateUtils.getString(TokenConstant.REDIS_TOKEN_PREFIX_LOGIN_UUID + userId);
        System.out.println("loginUUID: " + loginUUID);
        RedisPlatformUser dbUser = redisTemplateUtils.getObject(TokenConstant.REDIS_TOKEN_PREFIX_USER_INFO + userId, RedisPlatformUser.class);
        System.out.println("dbUser: " + JSONObject.toJSONString(dbUser));
    }
}
