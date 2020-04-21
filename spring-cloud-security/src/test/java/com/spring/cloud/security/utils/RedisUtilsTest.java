package com.spring.cloud.security.utils;

import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.commons.constant.RedisConst;
import com.spring.cloud.commons.entity.RedisUser;
import com.spring.cloud.web.commons.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisUtilsTest {
    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void set() {
        String key = "age";
        String value = "10";
        redisUtils.setString(key, value);

        redisUtils.increment(key, 20);

        System.out.println(redisUtils.getString(key));
    }

    @Test
    public void setObject() {
        RedisUser loginUser = new RedisUser();
        loginUser.setTenantId("tenant_000001");
        loginUser.setUsername("user_000001");

        redisUtils.setObject("login_user", loginUser);
        System.out.println(redisUtils.getObject("login_user", RedisUser.class));
    }

    @Test
    public void setList() {
        List<RedisUser> loginUserList = new ArrayList<>();

        RedisUser loginUser = new RedisUser();
        loginUser.setTenantId("tenant_000001");
        loginUser.setUsername("user_000001");
        loginUserList.add(loginUser);

        loginUser = new RedisUser();
        loginUser.setTenantId("tenant_000002");
        loginUser.setUsername("user_000002");
        loginUserList.add(loginUser);

        loginUser = new RedisUser();
        loginUser.setTenantId("tenant_000003");
        loginUser.setUsername("user_000003");
        loginUserList.add(loginUser);

        redisUtils.setList("login_user_list", loginUserList);
        System.out.println(redisUtils.getList("login_user_list", RedisUser.class));
    }

    @Test
    public void login() {
        for (int i = 1; i < 3; i++) {
            String userId = "user_00000" + i;
            String loginUUID = UUID.randomUUID().toString();
            RedisUser dbUser = new RedisUser();
            dbUser.setTenantId("tenant_00000" + i);
            dbUser.setUsername(userId);

            redisUtils.setString(RedisConst.TOKEN_PREFIX_LOGIN_UUID + userId, loginUUID, 2, TimeUnit.HOURS);
            redisUtils.setObject(RedisConst.TOKEN_PREFIX_USER_INFO + userId, dbUser, 2, TimeUnit.HOURS);
        }
    }

    @Test
    public void request() {
        String userId = "user_000001";
        String loginUUID = redisUtils.getString(RedisConst.TOKEN_PREFIX_LOGIN_UUID + userId);
        System.out.println("loginUUID: " + loginUUID);
        RedisUser dbUser = redisUtils.getObject(RedisConst.TOKEN_PREFIX_USER_INFO + userId, RedisUser.class);
        System.out.println("dbUser: " + JSONObject.toJSONString(dbUser));
    }
}
