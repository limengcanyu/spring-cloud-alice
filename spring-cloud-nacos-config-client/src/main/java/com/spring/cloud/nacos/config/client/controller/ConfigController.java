package com.spring.cloud.nacos.config.client.controller;

import com.spring.cloud.nacos.config.client.config.OrderProperties;
import com.spring.cloud.nacos.config.client.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
@RefreshScope
public class ConfigController {

    @Resource
    private ConfigService configService;

    /**
     * localhost:8800/getConfig
     *
     * @return
     */
    @RequestMapping("/getConfig")
    public String getConfig() {
        return configService.getConfig();
    }
}
