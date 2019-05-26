//package com.spring.cloud.security.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
///**
// * My UserDetailsService Impl
// *
// * @author rock
// * @date 2019/5/26
// */
//@Component
//public class MyUserDetailsServiceImpl implements UserDetailsService {
//    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsServiceImpl.class);
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        logger.debug("username: " + username);
//
//        return User.builder().username(username).password("123456").roles("USER","ADMIN").build();
//    }
//}
