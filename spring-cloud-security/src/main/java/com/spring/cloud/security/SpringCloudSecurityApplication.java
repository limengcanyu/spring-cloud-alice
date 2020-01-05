package com.spring.cloud.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Cloud Security Application
 *
 * @author jxf
 * @date 2019/11/01
 */
@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"com.spring.cloud.security", "com.spring.cloud.commons"})
public class SpringCloudSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSecurityApplication.class, args);
    }
}
