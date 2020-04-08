package com.spring.cloud.sentinel.controller;

import com.spring.cloud.sentinel.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/08 20:50
 */
@RestController
public class TestController {
    @Autowired
    private TestService service;

    /**
     * localhost:8800/hello/name
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/hello/{name}")
    public String apiHello(@PathVariable String name) {
        return service.sayHello(name);
    }
}
