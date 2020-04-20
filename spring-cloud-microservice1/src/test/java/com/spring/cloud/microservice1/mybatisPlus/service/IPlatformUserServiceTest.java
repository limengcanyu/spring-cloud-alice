package com.spring.cloud.microservice1.mybatisPlus.service;

import com.spring.cloud.commons.entity.RedisUser;
import com.spring.cloud.commons.utils.ContextUtils;
import com.spring.cloud.microservice1.mybatisPlus.entity.PlatformUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/20 21:03
 */
@Slf4j
@SpringBootTest
public class IPlatformUserServiceTest {

    @Autowired
    private IPlatformUserService platformUserService;

    @Test
    public void test() {
        ContextUtils.setUser(new RedisUser("tenant_000001", "company_000001", "rock"));
        PlatformUser platformUser = platformUserService.getById(1);
        log.debug("platformUser: {}", platformUser);
    }
}
