package com.spring.cloud.microservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Cloud MicroService3 Application
 *
 * @author jxf
 * @date 2019/5/26
 */
@RestController
@SpringBootApplication
public class SpringCloudMicroService3Application {
    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMicroService3Application.class, args);
    }
}
