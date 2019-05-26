package com.spring.cloud.security.service.impl;

import com.spring.cloud.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * User Service 实现类
 *
 * @author rock
 * @date 2019/5/26
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> loadUserByUsername(String username) {
        Map<String, String> userMap = new HashMap<>(5);
        userMap.put("username", "rock");
        userMap.put("password", passwordEncoder.encode("123456"));
        return userMap;
    }
}
