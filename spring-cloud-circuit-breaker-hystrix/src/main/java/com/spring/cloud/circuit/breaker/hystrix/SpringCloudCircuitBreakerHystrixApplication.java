package com.spring.cloud.circuit.breaker.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudCircuitBreakerHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudCircuitBreakerHystrixApplication.class, args);
    }

}
