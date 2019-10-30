package com.spring.cloud.sleuth.zipkin2;

import com.spring.cloud.sleuth.zipkin2.feignclient.EchoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
@SpringBootApplication
public class SpringCloudSleuthZipkin2Application {
    private static Logger logger = LoggerFactory.getLogger(SpringCloudSleuthZipkin2Application.class);

    @Autowired
    private EchoClient echoClient;

    @RequestMapping("/")
    public String home() {
        return "Hello spring-cloud-sleuth-zipkin2";
    }

    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str) {
        logger.info("echo " + str);
        return echoClient.echo("alita");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSleuthZipkin2Application.class, args);
    }

}
