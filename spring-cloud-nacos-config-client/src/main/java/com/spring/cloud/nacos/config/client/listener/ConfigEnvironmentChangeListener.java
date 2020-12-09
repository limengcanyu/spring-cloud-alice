package com.spring.cloud.nacos.config.client.listener;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 * 配置变化监听器
 * </p>
 *
 * @author rock.jxf
 * @date 2020/11/24 16:42
 */
@Slf4j
@Component
public class ConfigEnvironmentChangeListener implements ApplicationListener<EnvironmentChangeEvent> {
    @Resource
    private ConfigurableEnvironment environment;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        for (String key : event.getKeys()) {
            log.info("[onApplicationEvent][key({}) 最新 value 为 {}]", key, environment.getProperty(key));
        }
    }

}
