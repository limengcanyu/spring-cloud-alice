package com.spring.cloud.common.constant;

/**
 * <p>Description: Token Field Constant</p>
 *
 * @author rock.jiang
 * date 2019/06/28
 */
public class TokenConstant {
    /**
     * 请求中token名称
     */
    public static final String REQUEST_TOKEN_NAME = "token";
    /**
     * 请求中加密级别名称
     */
    public static final String REQUEST_ENCRYPTION_LEVEL_NAME = "level";
    /**
     * 请求中时间戳名称
     */
    public static final String REQUEST_TIMESTAMP_NAME = "timestamp";
    /**
     * 请求中签名字符串名称
     */
    public static final String REQUEST_SIGN_NAME = "sign";

    public static final String TOKEN_NAME_TENANT_ID = "tenant_id";
    public static final String TOKEN_NAME_COMPANY_ID = "company_id";
    public static final String TOKEN_NAME_USER_ID = "user_id";
    public static final String TOKEN_NAME_LOGIN_UUID = "login_uuid";
    public static final String TOKEN_NAME_REQUEST_UUID = "request_uuid";
}
