package com.spring.cloud.stream.rabbitmq.producer.config;

import com.spring.cloud.stream.rabbitmq.producer.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * description:
 *
 * @author rock
 * time 2020/7/16 0016 11:15
 */
@Configuration
public class ConsumerConfiguration {
    @Bean
    public Consumer<Person> personConsumer() {
        return person -> {
            System.out.println("Received: " + person);
        };
    }
}
