package com.spring.cloud.security.utils;

import com.spring.cloud.security.entity.RedisPlatformUser;

/**
 * <p>Description: User Context Utils</p>
 *
 * @author rock.jiang
 * date 2019/11/01
 */
public class UserContextUtils {
    private static ThreadLocal<RedisPlatformUser> userContext = new ThreadLocal<>();

    public static void setUser(RedisPlatformUser user) {
        userContext.remove();
        userContext.set(user);
    }

    public static RedisPlatformUser getUser() {
        return userContext.get();
    }
}
