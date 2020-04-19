package com.spring.cloud.security.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.commons.dto.LoginDto;
import com.spring.cloud.commons.dto.RegisterDto;
import com.spring.cloud.commons.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("登录Controller")
@RequestMapping("/auth")
@RestController
public class AuthenticateController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticateController.class);

//    @Autowired
//    private AuthenticateService authenticateService;

    @ApiOperation("登录Controller 注册")
    @RequestMapping("/register")
    public Result register(@RequestBody RegisterDto registerDto) {
        logger.debug("注册 registerUserDTO: {}", JSONObject.toJSONString(registerDto));

//        PlatformUser registerUser = new PlatformUser();
//        BeanUtils.copyProperties(registerUserDto, registerUser);
//
//        return authenticateService.register(registerUser);

        return new Result(0, null, null);
    }

    @ApiOperation("登录Controller 登录")
    @RequestMapping("/login")
    public Result login(@RequestBody LoginDto loginDto) {
        logger.debug("当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        logger.debug("登录 参数: {}", JSONObject.toJSONString(loginDto));

//        PlatformUser loginUser = new PlatformUser();
//        BeanUtils.copyProperties(loginUserDto, loginUser);
//
//        return authenticateService.login(loginUser);

        return new Result(0, null, null);
    }

    @ApiOperation("登录Controller 退出")
    @RequestMapping("/logout")
    public Result logout(@RequestParam String loginUserId) {
//        return authenticateService.logout(loginUserId);

        return new Result(0, null, null);
    }
}
