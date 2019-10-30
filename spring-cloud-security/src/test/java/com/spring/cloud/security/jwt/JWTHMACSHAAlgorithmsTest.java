package com.spring.cloud.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.junit.Test;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;

public class JWTHMACSHAAlgorithmsTest {
//    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256); //or HS384 or HS512
    SecretKey key = Keys.hmacShaKeyFor("12345678901234567890123456789012345678901234567890".getBytes()); //or HS384 or HS512

    @Test
    public void creatJWS() {
        Map<String,Object> header = new HashMap<>();
        header.put("kid", "myKeyId");

        Claims claims = Jwts.claims();
        claims.put("hello", "world");

        String jwsString = Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        System.out.println("jwsString: " + jwsString);

        try {
            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jwsString);
            System.out.println("jws: " + jws);
            // we can safely trust the JWT
        } catch (JwtException ex) {     // (4)
            // we *cannot* use the JWT as intended by its creator
            ex.printStackTrace();
        }
    }

    @Test
    public void readJWS() {
        try {
            String jwsString = "eyJraWQiOiJteUtleUlkIiwiYWxnIjoiSFMyNTYifQ.eyJoZWxsbyI6IndvcmxkIn0.8GX2gKrPl6Li9E2Cc7keFMQNKLgCcvETx73pOx2uB9k";

            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jwsString);
            System.out.println("jws: " + jws);
            // we can safely trust the JWT
        } catch (JwtException ex) {     // (4)
            // we *cannot* use the JWT as intended by its creator
            ex.printStackTrace();
        }
    }
}
