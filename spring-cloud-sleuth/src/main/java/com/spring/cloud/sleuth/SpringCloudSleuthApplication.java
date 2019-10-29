package com.spring.cloud.sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: SpringCloud Sleuth Application</p>
 *
 * @author rock.jiang
 * date 2019/09/11
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudSleuthApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringCloudSleuthApplication.class);

    @GetMapping("/")
    public String home() {
        return "Hello world";
    }

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        logger.info("SpringCloudSleuth Hello " + string);
        return "SpringCloudSleuth Hello " + string;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSleuthApplication.class, args);
    }
}
