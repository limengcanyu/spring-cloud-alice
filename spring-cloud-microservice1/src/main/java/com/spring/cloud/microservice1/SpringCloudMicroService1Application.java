package com.spring.cloud.microservice1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Cloud MicroService1 Application
 *
 * @author jxf
 * @date 2019/5/26
 */
@Api("hello app")
@RestController
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudMicroService1Application {
    private static Logger logger = LoggerFactory.getLogger(SpringCloudMicroService1Application.class);

    @ApiOperation(value = "获取用户列表", notes = "获取所有用户信息")
    @GetMapping("/")
    public String home() {
        return "Hello MicroService1";
    }

    @RequestMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        logger.info("MicroService1 Hello " + string);
        return "MicroService1 Hello " + string;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMicroService1Application.class, args);
    }
}
