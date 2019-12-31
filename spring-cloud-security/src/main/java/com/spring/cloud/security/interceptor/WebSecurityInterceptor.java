package com.spring.cloud.security.interceptor;

import com.spring.cloud.security.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Description: Web Security Interceptor</p>
 *
 * @author rock.jiang
 * Date 2019/11/28 17:18
 */
@Component
public class WebSecurityInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(WebSecurityInterceptor.class);

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("WebSecurityInterceptor 当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        logger.debug("Web安全拦截器 验证 开始");

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

        logger.debug("安全拦截器 OPTIONS 成功");
//
//        // 从请求header或者请求参数中获取token
//        String token = request.getHeader(TokenConstant.REQUEST_TOKEN_NAME);
//        if (StringUtils.isEmpty(token)) {
//            token = request.getParameter(TokenConstant.REQUEST_TOKEN_NAME);
//        }
//
//        // 未从请求中获取token，拦截器不通过
//        if (StringUtils.isEmpty(token)) {
//            logger.debug("安全拦截器 未从请求中获取token 失败");
//            response.setStatus(1000); // 响应状态为1000，表示未登陆
//            return false;
//        }
//
//        logger.debug("安全拦截器 从请求header或者请求参数中获取token 成功");
//
//        // 解析token
////        Claims tokenClaims = JJwtRsaAlgorithmsUtils.readJWS(token); // 该算法耗时较长
//        Claims tokenClaims = JJwtHsAlgorithmsUtils.readJWS(token);
//        if (CollectionUtils.isEmpty(tokenClaims)) {
//            logger.debug("安全拦截器 解析token 失败");
//            response.setStatus(1000); // 响应状态为1000，表示未登陆
//            return false;
//        }
//
//        logger.debug("安全拦截器 解析token 成功");
//
//        // 从token中获取登录uuid
//        String userId = tokenClaims.get(TokenConstant.TOKEN_NAME_USER_ID, String.class);
//        String loginUUIDOfToken = tokenClaims.get(TokenConstant.TOKEN_NAME_LOGIN_UUID, String.class);
////        String requestUUIDOfToken = tokenClaims.get(TokenConstant.TOKEN_NAME_REQUEST_UUID, String.class);
//
//        logger.debug("安全拦截器 从token中获取登录uuid 成功");
//
//        // 获取Redis中token
//        String loginUUIDOfRedis = redisUtils.getString(RedisConstant.REDIS_TOKEN_PREFIX_LOGIN_UUID + userId);
////        String requestUUIDOfRedis = tokenClaims.get(TokenConstant.REDIS_TOKEN_PREFIX_REQUEST_UUID + userId, String.class);
//
//        logger.debug("安全拦截器 获取Redis中token 成功");
//
//        logger.debug("安全拦截器 loginUUIDOfToken: {} loginUUIDOfRedis: {}", loginUUIDOfToken, loginUUIDOfRedis);
//
//        // 登录Token不一致
//        if (!ObjectUtils.nullSafeEquals(loginUUIDOfToken, loginUUIDOfRedis)) {
//            logger.debug("安全拦截器 登录Token不一致！");
//            response.setStatus(1000); // 响应状态为1000，表示未登陆
//            return false;
//        }
//
////        // 请求Token不一致
////        if (!ObjectUtils.nullSafeEquals(requestUUIDOfToken, requestUUIDOfRedis)) {
////            logger.debug("请求Token不一致！");
////            response.setStatus(1000); // 响应状态为1000，表示请求无效
////            return false;
////        }
//
//        logger.debug("############################## 验证Token成功！ ##############################");
//
//        // 刷新token #######################################################################
//
//        String requestUri = request.getRequestURI();
//        // 登出不刷新token，其余都刷新token，注册、登录不拦截
//        if (!ObjectUtils.nullSafeEquals(UriConstant.URI_LOGOUT, requestUri)) {
//            // token验证通过，刷新登录token失效时间
//            redisUtils.setString(RedisConstant.REDIS_TOKEN_PREFIX_LOGIN_UUID + userId, loginUUIDOfRedis, 2, TimeUnit.HOURS);
//            logger.debug("安全拦截器 刷新登录token成功！");
//
//            // 获取Redis中用户信息
//            RedisPlatformUser loginUser = redisUtils.getObject(RedisConstant.REDIS_TOKEN_PREFIX_USER_INFO + userId, RedisPlatformUser.class);
//            if (ObjectUtils.isEmpty(loginUser)) {
//                logger.debug("安全拦截器 Redis中用户信息不存在！");
//                response.setStatus(1000); // 响应状态为1000，表示未登陆
//                return false;
//            }
//            logger.debug("安全拦截器 Redis中用户信息: {}", JSONObject.toJSONString(loginUser));
//
//            // 设置当前用户上下文
//            ApplicationContextUtils.setUser(loginUser);
//            logger.debug("安全拦截器 上下文中用户: " + ApplicationContextUtils.getUser());
//        }

        logger.debug("Web安全拦截器 验证 结束");
        return true;
    }

}
