package com.spring.cloud.security.utils;

import com.spring.cloud.security.entity.RedisPlatformUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

/**
 * <p>Description: Application Context Utils</p>
 *
 * @author rock.jiang
 * Date 2019/11/28 17:16
 */
public class ContextUtils {
    private static final Logger logger = LoggerFactory.getLogger(ContextUtils.class);

    private static ThreadLocal<RedisPlatformUser> userContext = new ThreadLocal<>();

    public static void setUser(RedisPlatformUser user) {
        logger.debug("ApplicationContextUtils 当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        userContext.remove();
        userContext.set(user);
    }

    public static RedisPlatformUser getUser() {
        return userContext.get();
    }

    public static String getTenantId() {
        logger.debug("ApplicationContextUtils 当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        if (!ObjectUtils.isEmpty(userContext.get())) {
            return userContext.get().getTenantId();
        }
        return null;
    }

    public static String getCompanyId() {
        logger.debug("ApplicationContextUtils 当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        if (!ObjectUtils.isEmpty(userContext.get())) {
            return userContext.get().getCompanyId();
        }
        return null;
    }

    public static String getUserId() {
        logger.debug("ApplicationContextUtils 当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        if (!ObjectUtils.isEmpty(userContext.get())) {
            return userContext.get().getUserId();
        }
        return null;
    }
}
