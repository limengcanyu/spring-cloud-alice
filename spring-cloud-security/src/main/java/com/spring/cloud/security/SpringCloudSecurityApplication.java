package com.spring.cloud.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Cloud Security Application
 *
 * @author jxf
 * @date 2019/5/26
 */
@RestController
@SpringBootApplication
public class SpringCloudSecurityApplication {
    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Security Hello " + string;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSecurityApplication.class, args);
    }
}
