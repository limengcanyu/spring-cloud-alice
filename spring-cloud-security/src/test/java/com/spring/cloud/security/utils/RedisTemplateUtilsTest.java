package com.spring.cloud.security.utils;

import com.spring.cloud.security.entity.LoginUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
        LoginUser loginUser = new LoginUser();
        loginUser.setTenantId("tenant_000001");
        loginUser.setUserId("user_000001");
        loginUser.setPassword("123456");
        loginUser.setUserType(1);
        loginUser.setUserStatus(1);

        redisTemplateUtils.setObject("login_user", loginUser);
        System.out.println(redisTemplateUtils.getObject("login_user", LoginUser.class));
    }

    @Test
    public void setList() {
        List<LoginUser> loginUserList = new ArrayList<>();

        LoginUser loginUser = new LoginUser();
        loginUser.setTenantId("tenant_000001");
        loginUser.setUserId("user_000001");
        loginUser.setPassword("123456");
        loginUser.setUserType(1);
        loginUser.setUserStatus(1);
        loginUserList.add(loginUser);

        loginUser = new LoginUser();
        loginUser.setTenantId("tenant_000002");
        loginUser.setUserId("user_000002");
        loginUser.setPassword("123456");
        loginUser.setUserType(2);
        loginUser.setUserStatus(2);
        loginUserList.add(loginUser);

        loginUser = new LoginUser();
        loginUser.setTenantId("tenant_000003");
        loginUser.setUserId("user_000003");
        loginUser.setPassword("123456");
        loginUser.setUserType(3);
        loginUser.setUserStatus(3);
        loginUserList.add(loginUser);

        redisTemplateUtils.setList("login_user_list", loginUserList);
        System.out.println(redisTemplateUtils.getList("login_user_list", LoginUser.class));
    }
}
