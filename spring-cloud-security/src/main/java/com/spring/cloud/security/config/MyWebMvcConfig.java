package com.spring.cloud.security.config;

import com.spring.cloud.commons.constant.UriConst;
import com.spring.cloud.commons.interceptor.SignatureVerificationInterceptor;
import com.spring.cloud.commons.interceptor.WeiChatSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器类
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private WebSecurityInterceptor webSecurityInterceptor;

    @Autowired
    private WeiChatSecurityInterceptor weiChatSecurityInterceptor;

    @Autowired
    private SignatureVerificationInterceptor signatureVerificationInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

    /**
     * 拦截器按添加顺序依次执行
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 签名验证拦截器
        registry.addInterceptor(signatureVerificationInterceptor);

        // Web安全拦截器 swagger-ui、注册、登录不拦截
        registry.addInterceptor(webSecurityInterceptor).addPathPatterns("/**")
                .excludePathPatterns(
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/v2/**",
                        "/swagger-ui.html/**",
                        UriConst.REGISTER,
                        UriConst.LOGIN
                );

        // 微信安全拦截器
        registry.addInterceptor(weiChatSecurityInterceptor);

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //swagger增加url映射
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
