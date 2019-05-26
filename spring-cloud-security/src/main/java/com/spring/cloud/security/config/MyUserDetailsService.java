package com.spring.cloud.security.config;

import com.spring.cloud.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Map;

/**
 * 自定义 UserDetailsService ，根据 username 加载用户信息
 *
 * @author rock
 * @date 2019/5/26
 */
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    /**
     * 获取后台数据库用户认证信息
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, String> userMap =  userService.loadUserByUsername(username);

        return User.builder().username(userMap.get("username")).password(userMap.get("password")).roles("ROLE").build();
    }
}
