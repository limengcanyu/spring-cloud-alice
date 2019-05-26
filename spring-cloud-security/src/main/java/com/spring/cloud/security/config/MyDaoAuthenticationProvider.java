//package com.spring.cloud.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
///**
// * My DaoAuthenticationProvider
// *
// * @author rock
// * @date 2019/5/26
// */
//@Component
//public class MyDaoAuthenticationProvider extends DaoAuthenticationProvider {
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private MyUserDetailsServiceImpl myUserDetailsService;
//
//    @Override
//    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//        if (authentication.getCredentials() == null) {
//            logger.debug("Authentication failed: no credentials provided");
//
//            throw new BadCredentialsException(messages.getMessage(
//                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
//                    "Bad credentials"));
//        }
//
//        String presentedPassword = authentication.getCredentials().toString();
//
//        if (!passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
//            logger.debug("Authentication failed: password does not match stored value");
//
//            throw new BadCredentialsException(messages.getMessage(
//                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
//                    "Bad credentials"));
//        }
//    }
//}
