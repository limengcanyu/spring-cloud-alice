package com.spring.cloud.security.entity;

import lombok.Data;

/**
 * <p>
 * Redis平台用户
 * </p>
 *
 * @author rock
 * @since 2019-10-31
 */
@Data
public class RedisPlatformUser {
    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 公司ID
     */
    private String companyId;

    /**
     * 用户ID
     */
    private String userId;

}
