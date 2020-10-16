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
//@Configuration
public class FunctionConfiguration {
    /**
     * The following example shows a fully configured and functioning Spring Cloud Stream application
     * that receives the payload of the message as a String type (see Content Type Negotiation section),
     * logs it to the console and sends it down stream after converting it to upper case.
     *
     * @return
     */
    @Bean
    public Function<String, String> uppercase() {
        return String::toUpperCase;
    }
}
