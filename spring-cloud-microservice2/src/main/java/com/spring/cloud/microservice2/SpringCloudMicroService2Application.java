package com.spring.cloud.microservice2;

import com.spring.cloud.microservice2.feignclient.EchoClient;
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

/**
 * Spring Cloud MicroService2 Application
 *
 * @author jxf
 * @date 2019/5/26
 */
@RestController
@EnableFeignClients
@SpringBootApplication
public class SpringCloudMicroService2Application {
    private static Logger logger = LoggerFactory.getLogger(SpringCloudMicroService2Application.class);

    @Autowired
    private EchoClient echoClient;

    @RequestMapping("/")
    public String home() {
        return "MicroService2 home";
    }

    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str) {
        return "MicroService2 echo " + str;
    }

    @GetMapping("/echoClient/{str}")
    public String echoClient(@PathVariable String str) {
        return "MicroService2 echoClient " + echoClient.echo("alita");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMicroService2Application.class, args);
    }
}
