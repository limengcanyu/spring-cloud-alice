package com.spring.cloud.sleuth.zipkin1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudSleuthZipkin1Application {
    private static Logger logger = LoggerFactory.getLogger(SpringCloudSleuthZipkin1Application.class);

    @GetMapping("/")
    public String home() {
        return "Hello spring-cloud-sleuth-zipkin1";
    }

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        logger.info("spring-cloud-sleuth-zipkin1 Hello " + string);
        return "spring-cloud-sleuth-zipkin1 Hello " + string;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSleuthZipkin1Application.class, args);
    }

}
