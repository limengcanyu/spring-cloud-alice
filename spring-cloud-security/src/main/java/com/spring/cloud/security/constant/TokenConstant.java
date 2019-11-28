package com.spring.cloud.security.constant;

/**
 * <p>Description: Token Field Constant</p>
 *
 * @author rock.jiang
 * date 2019/06/28
 */
public class TokenConstant {
    public static final String REQUEST_TOKEN_NAME = "token";

    public static final String TOKEN_NAME_TENANT_ID = "tenant_id";
    public static final String TOKEN_NAME_USER_ID = "user_id";
    public static final String TOKEN_NAME_LOGIN_UUID = "login_uuid";
    public static final String TOKEN_NAME_REQUEST_UUID = "request_uuid";

    // 使用冒号，Redis中信息会分组
    public static final String REDIS_TOKEN_PREFIX_LOGIN_UUID = "login_uuid:";
    public static final String REDIS_TOKEN_PREFIX_REQUEST_UUID = "request_uuid:";
    public static final String REDIS_TOKEN_PREFIX_USER_INFO = "user_info:";
}
