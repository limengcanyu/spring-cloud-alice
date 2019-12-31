package com.spring.cloud.microservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Cloud MicroService1 Application
 *
 * @author jxf
 * @date 2019/5/26
 */
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudMicroService1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMicroService1Application.class, args);
    }
}
