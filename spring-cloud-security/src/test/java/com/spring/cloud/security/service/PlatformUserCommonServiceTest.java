package com.spring.cloud.security.service;

import com.spring.cloud.security.entity.RedisPlatformUser;
import com.spring.cloud.security.mybatisplus.entity.PlatformUser;
import com.spring.cloud.security.utils.ApplicationContextUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlatformUserCommonServiceTest {
    @Autowired
    private PlatformUserCommonService platformUserCommonService;

    @Test
    public void getPlatformUser() {
        RedisPlatformUser user = new RedisPlatformUser();
        user.setTenantId("tenant_000001");
        user.setCompanyId("company_000001");
        user.setUserId("user_000001");

        ApplicationContextUtils.setUser(user);

        PlatformUser platformUser = platformUserCommonService.getPlatformUser("user_000001");
        System.out.println(platformUser);
    }
}
