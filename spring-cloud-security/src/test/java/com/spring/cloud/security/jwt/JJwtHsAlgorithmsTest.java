package com.spring.cloud.security.jwt;

import com.spring.cloud.common.constant.JwtConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JJwtHsAlgorithmsTest {
    private SecretKey getSecretKey() {
        byte[] encodedKey = Base64.decodeBase64(JwtConstant.JWT_SECRET);
        return new SecretKeySpec(encodedKey, "HmacSHA256");
    }

    @Test
    public void creatJWS() {
        Map<String, Object> header = new HashMap<>();
        header.put("kid", "myKeyId");

        Claims claims = Jwts.claims();
        claims.put("hello", "world");

        long expiredDuration = 1000 * 60 * 60 * 2; // 过期时长 2小时

        Date expiration = new Date(System.currentTimeMillis() + expiredDuration);
        System.out.println("过期时间: " + expiration.getTime());

        String jwsString = Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                .setExpiration(expiration)
                .signWith(getSecretKey())
                .compact();
        System.out.println("jwsString: " + jwsString);

        try {
            Jws<Claims> jws = Jwts.parser()
                    .requireExpiration(expiration)
                    .setSigningKey(getSecretKey())
                    .parseClaimsJws(jwsString);
            System.out.println("jws: " + jws);
        } catch (JwtException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void readJWS() {
        try {
            String jwsString = "eyJraWQiOiJteUtleUlkIiwiYWxnIjoiSFMzODQifQ.eyJoZWxsbyI6IndvcmxkIiwiZXhwIjoxNTc4MDQ5NDQxfQ.OtKNRv3NXaJ-saZ_3_homW-P7UOaUld3HP3hTn94NHJkHLs9dVC-S661zI0UO1p_";

            Jws<Claims> jws = Jwts.parser()
                    .requireExpiration(new Date(Long.parseLong("1578049441524")))
                    .setSigningKey(getSecretKey())
                    .parseClaimsJws(jwsString);
            System.out.println("jws: " + jws);
        } catch (JwtException ex) {
            ex.printStackTrace();
        }
    }
}
