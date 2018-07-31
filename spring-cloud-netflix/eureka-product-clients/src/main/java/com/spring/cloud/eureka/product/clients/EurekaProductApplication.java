package com.spring.cloud.eureka.product.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication
public class EurekaProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaProductApplication.class);
    }
}
