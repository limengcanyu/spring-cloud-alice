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
        log.debug("ContextUtils 当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        userContext.remove();
        userContext.set(user);
    }

    public static RedisUser getUser() {
        return userContext.get();
    }

    public static String getTenantId() {
//        log.debug("ContextUtils 当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        if (!ObjectUtils.isEmpty(userContext.get())) {
            return userContext.get().getTenantId();
        }
        return null;
    }

    public static String getCompanyId() {
//        log.debug("ContextUtils 当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        if (!ObjectUtils.isEmpty(userContext.get())) {
            return userContext.get().getCompanyId();
        }
        return null;
    }

    public static String getUserId() {
//        log.debug("ContextUtils 当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        if (!ObjectUtils.isEmpty(userContext.get())) {
            return userContext.get().getUsername();
        }
        return null;
    }
}
