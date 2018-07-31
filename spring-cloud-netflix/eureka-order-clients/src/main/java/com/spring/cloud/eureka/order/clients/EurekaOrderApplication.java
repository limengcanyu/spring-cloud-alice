package com.spring.cloud.eureka.order.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients({"com.spring.cloud.eureka.product.feign.clients"})
@EnableTurbine
@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication(scanBasePackages = {"com.spring.cloud.eureka.order.clients","com.spring.cloud.eureka.product.feign.clients.fallback"})
public class EurekaOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaOrderApplication.class);
    }
}
