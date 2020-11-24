package com.spring.cloud.nacos.microservice1.listener;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 监听配置变化
 * </p>
 *
 * @author rock.jxf
 * @date 2020/11/24 16:42
 */
@Slf4j
@Component
public class DemoEnvironmentChangeListener implements ApplicationListener<EnvironmentChangeEvent> {
    @Autowired
    private ConfigurableEnvironment environment;

    @Autowired
    private StringEncryptor encryptor;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        for (String key : event.getKeys()) {
//            log.debug("key: {}", key);
//            if (ObjectUtils.nullSafeEquals("xxx-password", key)) {
//                log.info("[onApplicationEvent][key({}) 最新 value 为 {}]", key, encryptor.decrypt(environment.getProperty(key)));
//            } else {
//                log.info("[onApplicationEvent][key({}) 最新 value 为 {}]", key, environment.getProperty(key));
//            }

            log.info("[onApplicationEvent][key({}) 最新 value 为 {}]", key, environment.getProperty(key));

        }
    }

}
