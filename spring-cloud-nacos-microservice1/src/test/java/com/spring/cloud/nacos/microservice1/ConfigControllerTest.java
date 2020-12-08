package com.spring.cloud.nacos.microservice1;

import com.spring.cloud.nacos.microservice1.controller.ConfigController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ConfigControllerTest {

    @Autowired
    private ConfigController configController;

    @Test
    void getPayTimeoutSeconds() {
        Assert.isTrue(configController.getPayTimeoutSeconds() == 150, "ok");
    }
}
