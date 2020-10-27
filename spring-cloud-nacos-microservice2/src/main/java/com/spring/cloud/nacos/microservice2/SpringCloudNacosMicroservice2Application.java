package com.spring.cloud.nacos.microservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.spring.cloud.nacos.microservice2.feignclient")
@SpringBootApplication
public class SpringCloudNacosMicroservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNacosMicroservice2Application.class, args);
    }

}
