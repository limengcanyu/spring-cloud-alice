package com.spring.cloud.microservice2;

import com.spring.cloud.microservice2.feignclient.EchoClient;
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

    @Autowired
    private EchoClient echoClient;

    @RequestMapping("/")
    public String home() {
        return "Hello MicroService2";
    }

    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str) {
        return echoClient.echo("alita");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMicroService2Application.class, args);
    }
}
