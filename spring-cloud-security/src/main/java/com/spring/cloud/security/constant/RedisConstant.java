package com.spring.cloud.security.constant;

/**
 * <p>Description: Token Field Constant</p>
 *
 * @author rock.jiang
 * date 2019/06/28
 */
public class RedisConstant {
    // 使用冒号，Redis中信息会分组
    public static final String REDIS_TOKEN_PREFIX_LOGIN_UUID = "login_uuid:";
    public static final String REDIS_TOKEN_PREFIX_REQUEST_UUID = "request_uuid:";
    public static final String REDIS_TOKEN_PREFIX_USER_INFO = "user_info:";
}
