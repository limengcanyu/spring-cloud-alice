package com.spring.cloud.nacos.config.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * ConfigurationProperties 配置类
 * </p>
 *
 * @author rock.jxf
 * @date 2020/11/24 16:36
 */
@Data
@ConfigurationProperties(prefix = "order", ignoreInvalidFields = true)
@Configuration
public class OrderProperties {

    private String id;

    private String password;

}
