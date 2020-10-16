package com.spring.cloud.stream.rabbitmq.consumer.config;

import com.spring.cloud.stream.rabbitmq.producer.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

/**
 * description: 生产者
 *
 * @author rock
 * time 2020/7/16 0016 10:32
 */
@Configuration
public class SupplierConfiguration {
    @Bean
    public Supplier<String> stringSupplier() {
        return () -> "Hello from Supplier";
    }

    @Bean
    public Supplier<Person> personSupplier() {
        return () -> {
            Person person = new Person("rock");
            System.out.println("Send: " + person);
            return person;
        };
    }

}
