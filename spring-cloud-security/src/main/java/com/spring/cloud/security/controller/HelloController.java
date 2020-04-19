package com.spring.cloud.security.controller;


import com.spring.cloud.commons.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 平台用户表 前端控制器
 * </p>
 *
 * @author rock
 * @since 2019-10-31
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public Result hello() {
        logger.debug("HelloController 当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        return new Result(0, null);
    }
}

