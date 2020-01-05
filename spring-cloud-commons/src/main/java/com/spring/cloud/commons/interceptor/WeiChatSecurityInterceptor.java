package com.spring.cloud.commons.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Description: Weixin Security Interceptor</p>
 *
 * @author rock.jiang
 * Date 2019/11/28 17:18
 */
@Component
public class WeiChatSecurityInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(WeiChatSecurityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("微信安全拦截器 验证 开始");

        logger.debug("微信安全拦截器 验证 结束");
        return true;
    }
}
