package com.spring.cloud.security.auth;

import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.security.dto.LoginUserDTO;
import com.spring.cloud.security.dto.RegisterUserDTO;
import com.spring.cloud.security.mybatisplus.entity.PlatformUser;
import com.spring.cloud.security.result.JSONResult;
import com.spring.cloud.security.service.AuthenticateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("登录Controller")
@RequestMapping("/authenticate")
@RestController
public class AuthenticateController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticateController.class);

    @Autowired
    private AuthenticateService authenticateService;

    @ApiOperation("登录Controller 注册")
    @PostMapping("/register")
    public JSONResult register(@RequestBody RegisterUserDTO registerUserDTO) {
        logger.debug("注册 registerUserDTO: {}", JSONObject.toJSONString(registerUserDTO));

        PlatformUser registerUser = new PlatformUser();
        BeanUtils.copyProperties(registerUserDTO, registerUser);

        return authenticateService.register(registerUser);
    }

    @ApiOperation("登录Controller 登录")
    @PostMapping("/login")
    public JSONResult login(@RequestBody LoginUserDTO loginUserDTO) {
        logger.debug("登录 registerUserDTO: {}", JSONObject.toJSONString(loginUserDTO));

        PlatformUser loginUser = new PlatformUser();
        BeanUtils.copyProperties(loginUserDTO, loginUser);

        return authenticateService.login(loginUser);
    }

    @ApiOperation("登录Controller 退出")
    @PostMapping("/logout")
    public JSONResult logout(@RequestParam String loginUserId) {
        return authenticateService.logout(loginUserId);
    }
}
