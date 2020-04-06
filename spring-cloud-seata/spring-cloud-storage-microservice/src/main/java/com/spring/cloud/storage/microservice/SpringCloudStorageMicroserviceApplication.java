package com.spring.cloud.storage.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudStorageMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStorageMicroserviceApplication.class, args);
    }
    
}
