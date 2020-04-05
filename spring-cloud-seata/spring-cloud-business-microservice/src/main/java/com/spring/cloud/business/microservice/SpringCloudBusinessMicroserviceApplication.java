package com.spring.cloud.business.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringCloudBusinessMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudBusinessMicroserviceApplication.class, args);
	}

}
