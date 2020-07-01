package com.spring.cloud.circuit.breaker.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class SpringCloudCircuitBreakerHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudCircuitBreakerHystrixApplication.class, args);
    }

}
