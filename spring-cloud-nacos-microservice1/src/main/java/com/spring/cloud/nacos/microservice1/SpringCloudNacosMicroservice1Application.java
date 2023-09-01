package com.spring.cloud.nacos.microservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringCloudNacosMicroservice1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNacosMicroservice1Application.class, args);
    }

}