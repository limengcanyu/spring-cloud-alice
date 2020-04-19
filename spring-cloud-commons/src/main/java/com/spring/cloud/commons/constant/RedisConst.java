package com.spring.cloud.commons.constant;

/**
 * <p>Description: Token Field Constant</p>
 *
 * @author rock.jiang
 * date 2019/06/28
 */
public class RedisConst {
    // 使用冒号，Redis中信息会分组
    public static final String TOKEN_PREFIX_LOGIN_UUID = "login_uuid:";
    public static final String TOKEN_PREFIX_REQUEST_UUID = "request_uuid:";
    public static final String TOKEN_PREFIX_USER_INFO = "user_info:";
}
