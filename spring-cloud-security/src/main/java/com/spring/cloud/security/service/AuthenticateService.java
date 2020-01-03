package com.spring.cloud.security.service;

import com.spring.cloud.common.result.JSONResult;
import com.spring.cloud.security.mybatisplus.entity.PlatformUser;

public interface AuthenticateService {
    JSONResult register(PlatformUser registerUser);

    JSONResult login(PlatformUser loginUser);

    JSONResult logout(String loginUserId);
}
