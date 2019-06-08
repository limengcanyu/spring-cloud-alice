package com.spring.cloud.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.Test;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.UUID;

/**
 * comment
 *
 * @author rock
 * @date 2019/6/8
 */
public class JJwtTest {
    @Test
    public void RS256() {
        // Signing Key
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey= keyPair.getPrivate();

        Claims claims = Jwts.claims();
        claims.put("username", "rock");
        claims.put("password", "123456");

        String jws = Jwts.builder()
                .setIssuer("me")
                .setSubject("Bob")
                .setAudience("you")
//                .setExpiration(new Date()) //a java.util.Date
//                .setNotBefore(new Date()) //a java.util.Date
                .setIssuedAt(new Date()) // for example, now
                .setId("123456") //just an example id
                .setClaims(claims)
                .signWith(privateKey) // automatically choose the RS256 algorithm
                .compact();
        System.out.println("jws: " + jws);

        // Verification Key
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(publicKey) // <---- publicKey, not privateKey
                .parseClaimsJws(jws);
        System.out.println("claimsJws: " + claimsJws);
    }
}
