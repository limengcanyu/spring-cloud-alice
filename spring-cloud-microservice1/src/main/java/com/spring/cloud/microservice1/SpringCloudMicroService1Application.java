package com.spring.cloud.microservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Spring Cloud MicroService1 Application
 *
 * @author jxf
 * @date 2019/5/26
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.spring.cloud"})
public class SpringCloudMicroService1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMicroService1Application.class, args);
    }
}
