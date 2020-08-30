package com.spring.cloud.microservice1.service.impl;

//import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.spring.cloud.microservice1.service.SentinelService;
import org.springframework.stereotype.Service;

@Service
public class SentinelServiceImpl implements SentinelService {

//    @SentinelResource(value = "sayHello")
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
