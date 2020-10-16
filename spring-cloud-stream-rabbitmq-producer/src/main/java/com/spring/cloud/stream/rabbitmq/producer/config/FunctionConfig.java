package com.spring.cloud.stream.rabbitmq.producer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * Function定义的既是生产者，也是消费者
 *
 *
 */
@Slf4j
@Configuration
public class FunctionConfig {

    /**
     *
     * @return
     */
    @Bean
    public Function<String, String> uppercase() {
        return value -> {
            log.debug("============ uppercase: {}", value);
            return value.toUpperCase();
        };
    }
}
