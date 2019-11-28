package com.spring.cloud.security.utils;

import com.spring.cloud.security.entity.RedisPlatformUser;

/**
 * <p>Description: Application Context Utils</p>
 *
 * @author rock.jiang
 * Date 2019/11/28 17:16
 */
public class ApplicationContextUtils {
    private static ThreadLocal<String> tenantContext = new ThreadLocal<>();
    private static ThreadLocal<RedisPlatformUser> userContext = new ThreadLocal<>();

    public static void setTenantId(String tenantId) {
        tenantContext.remove();
        tenantContext.set(tenantId);
    }

    public static String getTenantId() {
        return tenantContext.get();
    }

    public static void setUser(RedisPlatformUser user) {
        userContext.remove();
        userContext.set(user);
    }

    public static RedisPlatformUser getUser() {
        return userContext.get();
    }
}
