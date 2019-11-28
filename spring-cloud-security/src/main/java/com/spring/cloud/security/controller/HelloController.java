package com.spring.cloud.security.controller;


import com.spring.cloud.security.result.JSONResult;
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

    @RequestMapping("/hello")
    public JSONResult hello() {
        return JSONResult.SUCCESS;
    }
}

