package com.spring.cloud.stream.rabbitmq.consumer;

import com.spring.cloud.stream.rabbitmq.consumer.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

/**
 * Spring Cloud Stream Rabbitmq Producer Application
 *
 * @author jxf
 * @date 2020/07/15
 */
@SpringBootApplication
public class SpringCloudStreamRabbitmqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamRabbitmqConsumerApplication.class, args);
    }
}
