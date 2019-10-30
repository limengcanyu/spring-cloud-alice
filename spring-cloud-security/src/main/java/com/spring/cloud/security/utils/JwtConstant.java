package com.spring.cloud.security.utils;

import java.util.UUID;

public class JwtConstant {
    public static final String JWT_ID = UUID.randomUUID().toString();

    /**
     * 加密密文
     */
    public static final String JWT_SECRET = "woyebuzhidaoxiediansha";
    public static final int JWT_TTL = 60*60*1000;  //millisecond
}
