package com.spring.boot.admin.client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootAdminClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminClient2Application.class, args);
    }

}
