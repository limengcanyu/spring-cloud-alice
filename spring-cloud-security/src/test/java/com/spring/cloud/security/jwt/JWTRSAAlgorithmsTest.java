package com.spring.cloud.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.junit.Test;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class JWTRSAAlgorithmsTest {
    KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256); //or RS384, RS512, PS256, PS384, PS512, ES256, ES384, ES512
    PublicKey publicKey = keyPair.getPublic();
    PrivateKey privateKey = keyPair.getPrivate();

    @Test
    public void creatJWS() {
        Map<String, Object> header = new HashMap<>();
        header.put("kid", "myKeyId");

        Claims claims = Jwts.claims();
        claims.put("hello", "world");

        String jwsString = Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                .signWith(privateKey)
                .compact();
        System.out.println("jwsString: " + jwsString);

        try {
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

    @Test
    public void readJWS() {
        try {
            String jwsString = "eyJraWQiOiJteUtleUlkIiwiYWxnIjoiUlMyNTYifQ.eyJoZWxsbyI6IndvcmxkIn0.Con9xb1PLBNUJVUyYcUW51iQ3cNY2UL6qKnclsn69tWRTEQbXQRvs-GB3mxy3fVg5K5UDa3_ardABIe_60JyoIIqWG4SgfIxxdDBKDtwJc4yZQVfL_ulZsVWjhe798F1eJ6bkI6Mpd_QwrnLvuMKVpZBBatZq8nU9EaodXInKwljBtLogb1tHFPhUnA_X5_LCrjCaJt2dn_rSIIsJdDv8s7kwUWmGJUY9ltSc1nakQzsd_z_f6Gjk3TK29iKlV0iIHUpNCzBf7bs0soyJtuOQIAyR8XpXsqErtAcPfdEelCkCd2duwXDkJyRuEWgK6iebRf-uuaFpzuQpAdT0UANFA";

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
