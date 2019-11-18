package com.spring.cloud.security.utils;

/**
 * <p>Description: Tenant Context Utils</p>
 *
 * @author rock.jiang
 * date 2019/11/01
 */
public class TenantContextUtils {
    private static ThreadLocal<String> tenantContext = new ThreadLocal<>();

    public static void setTenantId(String tenantId) {
        tenantContext.remove();
        tenantContext.set(tenantId);
    }

    public static String getTenantId() {
        return tenantContext.get();
    }
}
