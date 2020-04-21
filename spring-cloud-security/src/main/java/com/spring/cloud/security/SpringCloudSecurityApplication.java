package com.spring.cloud.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Cloud Security Application
 *
 * @author jxf
 * @date 2019/11/01
 */
@EnableSwagger2
@EnableTransactionManagement
@MapperScan("com.spring.cloud.security.mybatisplus.mapper")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.spring.cloud"})
public class SpringCloudSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSecurityApplication.class, args);
    }
}
