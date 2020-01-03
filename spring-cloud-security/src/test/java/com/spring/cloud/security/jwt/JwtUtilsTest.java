package com.spring.cloud.security.jwt;

import com.google.gson.Gson;
import com.spring.cloud.common.constant.JwtConstant;
import com.spring.cloud.common.entity.RedisPlatformUser;
import com.spring.cloud.common.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;

public class JwtUtilsTest {
    @Test
    public void createJwt() {
        RedisPlatformUser user = new RedisPlatformUser();
        String subject = new Gson().toJson(user);

        String jwt = JwtUtils.createJWT(JwtConstant.JWT_ID, "Anson", subject, JwtConstant.JWT_TTL);
        System.out.println("JWT：" + jwt);
    }

    @Test
    public void readJwt() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIxMjM0NTYiLCJ1c2VyX25hbWUiOiJhZG1pbiIsIm5pY2tfbmFtZSI6IlgtcmFwaWRvIiwianRpIjoiZTFjODhmMzYtNTM1NS00ZWQ2LWJjNjYtYWJjMzQyY2NkNjk0IiwiaWF0IjoxNTcyNDkyNzc3LCJpc3MiOiJBbnNvbiIsInN1YiI6Int9IiwiZXhwIjoxNTcyNDk2Mzc3fQ.56RcZYHbmoxBU462bP0ZCFZgkLIBpD5K5hN44UXZ0Gg";

        JwtUtils jwtUtils = new JwtUtils();
        Claims claims = JwtUtils.parseJWT(jwt);
        System.out.println(claims.getId());
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuer());
        System.out.println(claims.get("uid", String.class));
    }
}
