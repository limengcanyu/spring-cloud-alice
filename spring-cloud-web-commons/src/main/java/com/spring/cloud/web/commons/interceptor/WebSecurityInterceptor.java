package com.spring.cloud.web.commons.interceptor;

import com.spring.cloud.commons.constant.*;
import com.spring.cloud.commons.entity.RedisUser;
import com.spring.cloud.commons.result.Result;
import com.spring.cloud.commons.utils.*;
import com.spring.cloud.web.commons.utils.RedisUtils;
import com.spring.cloud.web.commons.utils.RequestUtils;
import com.spring.cloud.web.commons.utils.ResponseUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description: Web Security Interceptor</p>
 *
 * @author rock.jiang
 * Date 2019/11/28 17:18
 */
@Slf4j
@Component
public class WebSecurityInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("Web安全拦截器 验证 开始 =========================================================================");

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

        // 1. 验证 token 存在
        String token = StringUtils.isEmpty(request.getHeader(RequestConst.TOKEN_NAME)) ? request.getParameter("token") : null;
        if (StringUtils.isEmpty(token)) {
            ResponseUtils.writeFailedResponse(response, new Result(ResponseConst.UNAUTHORIZED_CODE, ResponseConst.UNAUTHORIZED_MESSAGE));
            return false;
        }

        log.debug("Web安全拦截器 验证token存在成功！");

        // 3. 验证 token 正确
        Claims tokenClaims = JJwtHsUtils.readJWS(token);
        if (CollectionUtils.isEmpty(tokenClaims)) {
            ResponseUtils.writeFailedResponse(response, new Result(ResponseConst.UNAUTHORIZED_CODE, ResponseConst.UNAUTHORIZED_MESSAGE));
            return false;
        }

        // 从token中获取登录uuid
        String userId = tokenClaims.get(TokenConst.USER_ID, String.class);
        String loginUUIDOfToken = tokenClaims.get(TokenConst.LOGIN_UUID, String.class);

        // 获取Redis中token
        String loginUUIDOfRedis = redisUtils.getString(RedisConst.TOKEN_PREFIX_LOGIN_UUID + userId);

        // 登录Token不一致
        if (!ObjectUtils.nullSafeEquals(loginUUIDOfToken, loginUUIDOfRedis)) {
            ResponseUtils.writeFailedResponse(response, new Result(ResponseConst.UNAUTHORIZED_CODE, ResponseConst.UNAUTHORIZED_MESSAGE));
            return false;
        }

        log.debug("Web安全拦截器 验证token正确成功！");

        // 验证参数签名
        int level = request.getIntHeader(RequestConst.ENCRYPTION_LEVEL_NAME);
        long timestamp = Long.parseLong(request.getHeader("timestamp"));
        String signOfRequest = request.getHeader(RequestConst.SIGN_NAME);
        SortedMap<String, Object> paramMap = RequestUtils.getRequestParams(request);
        if (!SignatureUtils.verifySignature(level, timestamp, signOfRequest, paramMap, token)) {
            ResponseUtils.writeFailedResponse(response, new Result(ResponseConst.SIGNATURE_FAILED_CODE, ResponseConst.SIGNATURE_FAILED_MESSAGE));
            return false;
        }

        log.debug("Web安全拦截器 验证参数签名成功！");

        // 刷新token #######################################################################

        String requestUri = request.getRequestURI();
        // 登出不刷新token，其余都刷新token，注册、登录不拦截
        if (!ObjectUtils.nullSafeEquals(UriConst.LOGOUT, requestUri)) {
            // 刷新token失效时间
            redisUtils.setString(RedisConst.TOKEN_PREFIX_LOGIN_UUID + userId, loginUUIDOfRedis, 2, TimeUnit.HOURS);

            // 获取Redis中用户信息
            RedisUser loginUser = redisUtils.getObject(RedisConst.TOKEN_PREFIX_USER_INFO + userId, RedisUser.class);
            if (ObjectUtils.isEmpty(loginUser)) {
                ResponseUtils.writeFailedResponse(response, new Result(ResponseConst.UNAUTHORIZED_CODE, ResponseConst.UNAUTHORIZED_MESSAGE));
                return false;
            }
            // 刷新用户信息失效时间
            redisUtils.setObject(RedisConst.TOKEN_PREFIX_USER_INFO + userId, RedisUser.class, 2, TimeUnit.HOURS);

            // 设置当前用户上下文
            ContextUtils.setUser(loginUser);
        }

        log.debug("Web安全拦截器 刷新token成功！");

        log.debug("Web安全拦截器 验证 结束 =========================================================================");
        return true;
    }

}
