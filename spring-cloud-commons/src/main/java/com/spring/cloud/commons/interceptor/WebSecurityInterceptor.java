package com.spring.cloud.commons.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.commons.constant.RedisConstant;
import com.spring.cloud.commons.constant.ResponseConstant;
import com.spring.cloud.commons.constant.TokenConstant;
import com.spring.cloud.commons.constant.UriConstant;
import com.spring.cloud.commons.entity.RedisPlatformUser;
import com.spring.cloud.commons.result.JSONResult;
import com.spring.cloud.commons.utils.*;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description: Web Security Interceptor</p>
 *
 * @author rock.jiang
 * Date 2019/11/28 17:18
 */
@Component
@AllArgsConstructor
public class WebSecurityInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(WebSecurityInterceptor.class);

    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("Web安全拦截器 验证 开始 =========================================================================");
        logger.debug("Web安全拦截器 当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        // 验证token #######################################################################

        // 跨域资源共享标准新增了一组 HTTP 首部字段，允许服务器声明哪些源站通过浏览器有权限访问哪些资源。
        // 另外，规范要求，对那些可能对服务器数据产生副作用的 HTTP 请求方法（特别是 GET 以外的 HTTP 请求，或者搭配某些 MIME 类型的 POST 请求），
        // 浏览器必须首先使用 OPTIONS 方法发起一个预检请求（preflight request），从而获知服务端是否允许该跨域请求。
        // 服务器确认允许之后，才发起实际的 HTTP 请求。
        // 在预检请求的返回中，服务器端也可以通知客户端，是否需要携带身份凭证（包括 Cookies 和 HTTP 认证相关数据）。
        // 参考：https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Access_control_CORS
        String requestMethod = request.getMethod();
        if ("OPTIONS".equals(requestMethod)) {
            return true;
        }

        logger.debug("Web安全拦截器 OPTIONS 成功");

        // 1. 从请求header中获取token
        String token = request.getHeader(TokenConstant.REQUEST_TOKEN_NAME);
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        // 2. token不存在
        if (StringUtils.isEmpty(token)) {
            logger.debug("Web安全拦截器 token不存在！");

            JSONResult jsonResult = new JSONResult(ResponseConstant.STATUS_UNAUTHORIZED_CODE, ResponseConstant.STATUS_UNAUTHORIZED_MESSAGE);
            ResponseUtils.writeFailedResponse(response, jsonResult);
            return false;
        }

        // 3. 解析token
        Claims tokenClaims = JJwtHsUtils.readJWS(token);
        if (CollectionUtils.isEmpty(tokenClaims)) {
            logger.debug("Web安全拦截器 解析token失败！");

            JSONResult jsonResult = new JSONResult(ResponseConstant.STATUS_UNAUTHORIZED_CODE, ResponseConstant.STATUS_UNAUTHORIZED_MESSAGE);
            ResponseUtils.writeFailedResponse(response, jsonResult);
            return false;
        }

        logger.debug("Web安全拦截器 解析token 成功！");

        // 从token中获取登录uuid
        String userId = tokenClaims.get(TokenConstant.TOKEN_NAME_USER_ID, String.class);
        String loginUUIDOfToken = tokenClaims.get(TokenConstant.TOKEN_NAME_LOGIN_UUID, String.class);

        logger.debug("Web安全拦截器 从token中获取登录uuid成功！");

        // 获取Redis中token
        String loginUUIDOfRedis = redisUtils.getString(RedisConstant.REDIS_TOKEN_PREFIX_LOGIN_UUID + userId);

        logger.debug("Web安全拦截器 获取Redis中token成功！");

        logger.debug("Web安全拦截器 loginUUIDOfToken: {} loginUUIDOfRedis: {}", loginUUIDOfToken, loginUUIDOfRedis);

        // 登录Token不一致
        if (!ObjectUtils.nullSafeEquals(loginUUIDOfToken, loginUUIDOfRedis)) {
            logger.debug("Web安全拦截器 登录Token不一致！");

            JSONResult jsonResult = new JSONResult(ResponseConstant.STATUS_UNAUTHORIZED_CODE, ResponseConstant.STATUS_UNAUTHORIZED_MESSAGE);
            ResponseUtils.writeFailedResponse(response, jsonResult);
            return false;
        }

        logger.debug("############################## 验证Token成功！ ##############################");

        // 验证参数签名
        if (!SignatureUtils.verifySignature(request, token)) {
            logger.debug("Web安全拦截器 参数签名验证失败！");

            JSONResult jsonResult = new JSONResult(ResponseConstant.STATUS_VERIFY_SIGNATURE_FAILED_CODE, ResponseConstant.STATUS_VERIFY_SIGNATURE_FAILED_MESSAGE);
            ResponseUtils.writeFailedResponse(response, jsonResult);
            return false;
        }

        // 刷新token #######################################################################

        String requestUri = request.getRequestURI();
        // 登出不刷新token，其余都刷新token，注册、登录不拦截
        if (!ObjectUtils.nullSafeEquals(UriConstant.URI_LOGOUT, requestUri)) {
            // 刷新token失效时间
            redisUtils.setString(RedisConstant.REDIS_TOKEN_PREFIX_LOGIN_UUID + userId, loginUUIDOfRedis, 2, TimeUnit.HOURS);
            logger.debug("Web安全拦截器 刷新token成功！");

            // 获取Redis中用户信息
            RedisPlatformUser loginUser = redisUtils.getObject(RedisConstant.REDIS_TOKEN_PREFIX_USER_INFO + userId, RedisPlatformUser.class);
            if (ObjectUtils.isEmpty(loginUser)) {
                logger.debug("Web安全拦截器 Redis中用户信息不存在！");

                JSONResult jsonResult = new JSONResult(ResponseConstant.STATUS_UNAUTHORIZED_CODE, ResponseConstant.STATUS_UNAUTHORIZED_MESSAGE);
                ResponseUtils.writeFailedResponse(response, jsonResult);
                return false;
            }
            // 刷新用户信息失效时间
            redisUtils.setObject(RedisConstant.REDIS_TOKEN_PREFIX_USER_INFO + userId, RedisPlatformUser.class, 2, TimeUnit.HOURS);
            logger.debug("Web安全拦截器 Redis中用户信息: {}", JSONObject.toJSONString(loginUser));

            // 设置当前用户上下文
            ContextUtils.setUser(loginUser);
            logger.debug("Web安全拦截器 上下文中用户信息: {}", JSONObject.toJSONString(ContextUtils.getUser()));
        }

        logger.debug("Web安全拦截器 验证 结束 =========================================================================");
        return true;
    }

}
