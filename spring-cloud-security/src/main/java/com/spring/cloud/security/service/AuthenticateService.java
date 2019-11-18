package com.spring.cloud.security.service;

import com.spring.cloud.security.mybatisplus.entity.PlatformUser;
import com.spring.cloud.security.result.JSONResult;

public interface AuthenticateService {
    JSONResult register(PlatformUser registerUser);

    JSONResult login(PlatformUser loginUser);

    JSONResult logout(String loginUserId);
}
