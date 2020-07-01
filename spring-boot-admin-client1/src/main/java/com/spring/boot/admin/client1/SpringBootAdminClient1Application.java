package com.spring.boot.admin.client1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootAdminClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminClient1Application.class, args);
    }

}
