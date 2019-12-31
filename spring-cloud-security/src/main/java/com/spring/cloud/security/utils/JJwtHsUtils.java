package com.spring.cloud.security.utils;

import com.spring.cloud.security.constant.JwtConstant;
import com.spring.cloud.security.constant.TokenConstant;
import io.jsonwebtoken.*;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class JJwtHsUtils {
    private static SecretKey getSecretKey() {
        byte[] encodedKey = Base64.decodeBase64(JwtConstant.JWT_SECRET);
        return new SecretKeySpec(encodedKey, "HmacSHA256");
    }

    public static String creatJWS(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public static String creatJWS(String tenantId, String companyId, String userId, String loginUUID) {
        Claims claims = Jwts.claims();

        claims.put(TokenConstant.TOKEN_NAME_TENANT_ID, tenantId);
        claims.put(TokenConstant.TOKEN_NAME_COMPANY_ID, companyId);
        claims.put(TokenConstant.TOKEN_NAME_USER_ID, userId);
        claims.put(TokenConstant.TOKEN_NAME_LOGIN_UUID, loginUUID);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(getSecretKey())
                .compact();
    }

    public static Claims readJWS(String jwsString){
        try {
            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey(getSecretKey())
                    .parseClaimsJws(jwsString);
            return jws.getBody();
        } catch (JwtException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
