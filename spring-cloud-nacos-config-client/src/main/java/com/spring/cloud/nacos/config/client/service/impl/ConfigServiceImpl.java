package com.spring.cloud.nacos.config.client.service.impl;

import com.spring.cloud.nacos.config.client.config.OrderProperties;
import com.spring.cloud.nacos.config.client.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@RefreshScope
@Service
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private OrderProperties orderProperties;

    @Value("${useLocalCache:false}")
    private String useLocalCache;

    @Value("${product.id}")
    private String productId;

    @Override
    public String getConfig() {
        String result = "";

        result += " productId: " + productId + " useLocalCache: " + useLocalCache;
        result += " order id: " + orderProperties.getId() + " password: " + orderProperties.getPassword();

        return result;
    }
}
