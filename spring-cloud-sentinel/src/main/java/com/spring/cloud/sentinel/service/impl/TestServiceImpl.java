package com.spring.cloud.sentinel.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.spring.cloud.sentinel.service.TestService;
import org.springframework.stereotype.Service;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/08 20:49
 */
@Service
public class TestServiceImpl implements TestService {
    @SentinelResource(value = "sayHello")
    @Override
    public String sayHello(String name) {
        return "null";
    }
}
