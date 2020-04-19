package com.spring.cloud.commons.utils;

import com.spring.cloud.commons.constant.JwtConst;
import com.spring.cloud.commons.constant.TokenConst;
import com.spring.cloud.commons.entity.JwtClaims;
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
        SecureRandom random = new SecureRandom(JwtConst.SECRET_KEY.getBytes());
        KeyPair keyPair = RsaProvider.generateKeyPair(keySizeInBits, random);
        return keyPair.getPublic();
    }

    private static PrivateKey getPrivateKey() {
        int keySizeInBits = 4096;
        SecureRandom random = new SecureRandom(JwtConst.SECRET_KEY.getBytes());
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

        claims.put(TokenConst.TENANT_ID, jwtClaims.getTenantId());
        claims.put(TokenConst.COMPANY_ID, jwtClaims.getCompanyId());
        claims.put(TokenConst.USER_ID, jwtClaims.getUsername());
        claims.put(TokenConst.LOGIN_UUID, jwtClaims.getLoginUUID());

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
