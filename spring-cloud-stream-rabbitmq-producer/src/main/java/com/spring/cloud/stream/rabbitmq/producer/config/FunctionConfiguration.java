package com.spring.cloud.stream.rabbitmq.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * description:
 *
 * @author rock
 * time 2020/7/16 0016 11:15
 */
@Configuration
public class FunctionConfiguration {
    @Bean
    public Function<String, String> uppercase() {
        return String::toUpperCase;
    }
}
