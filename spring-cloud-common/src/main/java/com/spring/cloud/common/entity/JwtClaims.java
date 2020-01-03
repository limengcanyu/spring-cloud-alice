package com.spring.cloud.common.entity;

import lombok.Data;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/01/03 15:59
 */
@Data
public class JwtClaims {
    private String tenantId;
    private String companyId;
    private String userId;
    private String loginUUID;

    public JwtClaims(String tenantId, String companyId, String userId, String loginUUID) {
        this.tenantId = tenantId;
        this.companyId = companyId;
        this.userId = userId;
        this.loginUUID = loginUUID;
    }
}
