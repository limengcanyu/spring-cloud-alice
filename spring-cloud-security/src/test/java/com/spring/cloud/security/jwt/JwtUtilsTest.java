package com.spring.cloud.security.jwt;

import com.google.gson.Gson;
import com.spring.cloud.security.entity.LoginUser;
import com.spring.cloud.security.utils.JwtConstant;
import com.spring.cloud.security.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;

public class JwtUtilsTest {
    @Test
    public void createJwt() {
        LoginUser user = new LoginUser();
        String subject = new Gson().toJson(user);

        JwtUtils jwtUtils = new JwtUtils();
        String jwt = jwtUtils.createJWT(JwtConstant.JWT_ID, "Anson", subject, JwtConstant.JWT_TTL);
        System.out.println("JWT：" + jwt);
    }

    @Test
    public void readJwt() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIxMjM0NTYiLCJ1c2VyX25hbWUiOiJhZG1pbiIsIm5pY2tfbmFtZSI6IlgtcmFwaWRvIiwianRpIjoiOGVmMWI5NGItODk3MS00ZWM2LWExZTctODY4OTk4NzBkM2UzIiwiaWF0IjoxNTcyNDQ2OTk4LCJpc3MiOiJBbnNvbiIsInN1YiI6Int9IiwiZXhwIjoxNTcyNDUwNTk4fQ.O8nijGDJ8upbwzsybkXZm8tB97tIZWiZQmvGhZK8IiU";

        JwtUtils jwtUtils = new JwtUtils();
        Claims claims = jwtUtils.parseJWT(jwt);
        System.out.println(claims.getId());
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuer());
        System.out.println(claims.get("uid", String.class));
    }
}
