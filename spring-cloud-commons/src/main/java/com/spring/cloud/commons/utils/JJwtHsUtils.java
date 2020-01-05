package com.spring.cloud.commons.utils;

import com.spring.cloud.commons.constant.JwtConstant;
import com.spring.cloud.commons.constant.TokenConstant;
import com.spring.cloud.commons.entity.JwtClaims;
import io.jsonwebtoken.*;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class JJwtHsUtils {
    private static SecretKey getSecretKey() {
        byte[] encodedKey = Base64.decodeBase64(JwtConstant.SECRET_KEY);
        return new SecretKeySpec(encodedKey, "HmacSHA256");
    }

    public static String creatJWS(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
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
//                .setId(UUID.randomUUID().toString()) // JWT唯一标识
//                .setIssuedAt(new Date()) // jwt的签发时间
//                .setIssuer(JwtConstant.ISSUER) // jwt签发人
//                .setSubject(JwtConstant.ISSUER) // JWT的主体，即它的所有人，一个json格式的字符串
//                .setExpiration(new Date())
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
