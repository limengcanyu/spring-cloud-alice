package com.spring.cloud.common.utils;

import com.spring.cloud.common.constant.JwtConstant;
import com.spring.cloud.common.constant.TokenConstant;
import com.spring.cloud.common.entity.JwtClaims;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.crypto.RsaProvider;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class JJwtRsaUtils {
    private static PublicKey getPublicKey() {
        int keySizeInBits = 4096;
        SecureRandom random = new SecureRandom(JwtConstant.SECRET_KEY.getBytes());
        KeyPair keyPair = RsaProvider.generateKeyPair(keySizeInBits, random);
        return keyPair.getPublic();
    }

    private static PrivateKey getPrivateKey() {
        int keySizeInBits = 4096;
        SecureRandom random = new SecureRandom(JwtConstant.SECRET_KEY.getBytes());
        KeyPair keyPair = RsaProvider.generateKeyPair(keySizeInBits, random);
        return keyPair.getPrivate();
    }

    public static String creatJWS(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(getPrivateKey())
                .compact();
    }

    public static String creatJWS(JwtClaims jwtClaims) {
        Claims claims = Jwts.claims();

        claims.put(TokenConstant.TOKEN_NAME_TENANT_ID, jwtClaims.getTenantId());
        claims.put(TokenConstant.TOKEN_NAME_COMPANY_ID, jwtClaims.getCompanyId());
        claims.put(TokenConstant.TOKEN_NAME_USER_ID, jwtClaims.getUserId());
        claims.put(TokenConstant.TOKEN_NAME_LOGIN_UUID, jwtClaims.getLoginUUID());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(getPrivateKey())
                .compact();
    }

    public static Claims readJWS(String jwsString) {
        try {
            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey(getPublicKey())
                    .parseClaimsJws(jwsString);
            return jws.getBody();
        } catch (JwtException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
