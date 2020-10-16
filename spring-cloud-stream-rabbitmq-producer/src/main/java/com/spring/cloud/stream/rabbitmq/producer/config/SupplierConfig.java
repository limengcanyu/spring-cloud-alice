package com.spring.cloud.stream.rabbitmq.producer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Supplier;

@Slf4j
@Configuration
public class SupplierConfig {

    @Bean
    public Supplier<String> stringSupplier() {
        log.debug("============ supplier date");
        return () -> "string Supplier";
    }

}
