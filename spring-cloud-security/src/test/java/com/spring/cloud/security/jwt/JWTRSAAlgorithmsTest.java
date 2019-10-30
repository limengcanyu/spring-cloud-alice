package com.spring.cloud.security.jwt;

import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.security.utils.RedisTemplateUtils;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JWTRSAAlgorithmsTest {
    @Autowired
    private RedisTemplateUtils redisTemplateUtils;

    KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256); //or RS384, RS512, PS256, PS384, PS512, ES256, ES384, ES512
    PublicKey publicKey = keyPair.getPublic();
    PrivateKey privateKey = keyPair.getPrivate();

    @Test
    public void creatJWS() {
        String publicKeyJSONString = JSONObject.toJSONString(publicKey);
        String privateKeyJSONString = JSONObject.toJSONString(privateKey);

        System.out.println("publicKey JSONString: " + publicKeyJSONString);
        System.out.println("privateKey JSONString: " + privateKeyJSONString);

        publicKey = JSONObject.parseObject(publicKeyJSONString, PublicKey.class);
        privateKey = JSONObject.parseObject(privateKeyJSONString, PrivateKey.class);

        System.out.println("publicKey: " + publicKey);
        System.out.println("privateKey: " + privateKey);

        Map<String,Object> header = new HashMap<>();
        header.put("kid", "myKeyId");

        Claims claims = Jwts.claims();
        claims.put("hello", "world");

        String jwsString = Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                .signWith(privateKey)
                .compact();
        System.out.println("jwsString: " + jwsString);

//        redisTemplateUtils.setString("rs256_publicKey", JSONObject.toJSONString(publicKey));
//        redisTemplateUtils.setString("rs256_privateKey", JSONObject.toJSONString(privateKey));
    }

    @Test
    public void readJWS() {
        System.out.println("publicKey: " + JSONObject.toJSONString(publicKey));
        System.out.println("privateKey: " + JSONObject.toJSONString(privateKey));

        try {
            String jwsString = "eyJraWQiOiJteUtleUlkIiwiYWxnIjoiUlMyNTYifQ.eyJoZWxsbyI6IndvcmxkIn0.LMGp6HRxkFNXAkbWy3FLboPZGStNAA6UrHI8v0nELa9FDXCvBlnGDMrGobOdGmb1pAlQ5Kl1p5TYCnBm3AGmMNnKfj3lOJcNPk4uxULuUyM9UvBz-lbBo2c9__RSXVmmeL9EnrLp4FdnN1_yauDG8e_W8J4NjVPlnz8d6Tsx-6a8ErEN-NHVa7KgPDhiKUdKs-sCJcdc8Gxsms7f6krhacecmkO9TUtFJUDu-UOotlvn_yr7kbliuBxG9_UsRerZcPyTtVyL-z4qGwuG2uq6LNi5xIQ4d-cyEvq5NrfhJP9ZZgu6dFWAkbUmuFhOrHzVIJRundQJRgXT4vIcYaQDZA";

            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey(publicKey)
                    .parseClaimsJws(jwsString);
            System.out.println("jws: " + jws);
            // we can safely trust the JWT
        } catch (JwtException ex) {     // (4)
            // we *cannot* use the JWT as intended by its creator
            ex.printStackTrace();
        }
    }
}
