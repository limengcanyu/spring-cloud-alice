package com.spring.cloud.nacos.microservice1.controller;

import com.spring.cloud.nacos.microservice1.config.OrderProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author rock.jxf
 * @date 2020/11/24 16:28
 */
@Slf4j
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Autowired
    private OrderProperties orderProperties;

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value(value = "${order.pay-timeout-seconds}")
    private Integer payTimeoutSeconds;

    @Value("${order.xxx-password:}")
    private String xxxPassword;

    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }

    /**
     * localhost:8800/config/getPayTimeoutSeconds
     *
     * @return
     */
    @RequestMapping("/getPayTimeoutSeconds")
    public int getPayTimeoutSeconds() {
        log.debug("payTimeoutSeconds: {}", payTimeoutSeconds);
        log.debug("xxx-password: {}", xxxPassword);

        log.debug("orderProperties payTimeoutSeconds: {}", orderProperties.getPayTimeoutSeconds());
        log.debug("orderProperties xxx-password: {}", orderProperties.getXxxPassword());

        return payTimeoutSeconds;
    }
}
