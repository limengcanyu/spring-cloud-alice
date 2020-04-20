package com.spring.cloud.commons.utils;

import com.spring.cloud.commons.entity.RedisUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

/**
 * <p>Description: Context Utils</p>
 *
 * @author rock.jiang
 * Date 2019/11/28 17:16
 */
@Slf4j
public class ContextUtils {
    private static final ThreadLocal<RedisUser> userContext = new ThreadLocal<>();

    public static void setUser(RedisUser user) {
        userContext.remove();
        userContext.set(user);
    }

    public static String getTenantId() {
        if (!ObjectUtils.isEmpty(userContext.get())) {
            return userContext.get().getTenantId();
        }
        return null;
    }

    public static String getCompanyId() {
        if (!ObjectUtils.isEmpty(userContext.get())) {
            return userContext.get().getCompanyId();
        }
        return null;
    }

    public static String getUsername() {
        if (!ObjectUtils.isEmpty(userContext.get())) {
            return userContext.get().getUsername();
        }
        return null;
    }
}
