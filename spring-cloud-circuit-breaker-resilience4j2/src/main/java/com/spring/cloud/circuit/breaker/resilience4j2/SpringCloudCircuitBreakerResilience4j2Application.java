package com.spring.cloud.circuit.breaker.resilience4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudCircuitBreakerResilience4j2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudCircuitBreakerResilience4j2Application.class, args);
    }

}
