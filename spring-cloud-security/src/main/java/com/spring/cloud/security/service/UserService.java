package com.spring.cloud.security.service;

import java.util.Map;

/**
 * User Service，用来更具用户名获取用户信息
 *
 * @author rock
 * @date 2019/5/26
 */
public interface UserService {

    /**
     * 根据username获取用户信息
     *
     * @param username
     * @return
     */
    Map<String, String> loadUserByUsername(String username);
}
