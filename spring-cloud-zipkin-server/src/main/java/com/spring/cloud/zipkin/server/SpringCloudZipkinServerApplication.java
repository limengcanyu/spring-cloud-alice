package com.spring.cloud.zipkin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;


@EnableZipkinServer
@SpringBootApplication
public class SpringCloudZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZipkinServerApplication.class, args);
    }

}
