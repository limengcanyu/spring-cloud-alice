package com.spring.cloud.microservice2.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("spring-cloud-microservice1")
public interface EchoClient {
    @GetMapping("/echo/{str}")
    String echo(@PathVariable String str);
}
