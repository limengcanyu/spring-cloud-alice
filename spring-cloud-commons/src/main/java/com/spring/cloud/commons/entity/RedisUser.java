package com.spring.cloud.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * Redis平台用户
 * </p>
 *
 * @author rock
 * @since 2019-10-31
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RedisUser {
    private String tenantId;
    private String companyId;
    private String username;
}
