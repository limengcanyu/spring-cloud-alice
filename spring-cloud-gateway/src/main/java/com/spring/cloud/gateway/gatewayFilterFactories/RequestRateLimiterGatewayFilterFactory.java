package com.spring.cloud.gateway.gatewayFilterFactories;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class RequestRateLimiterGatewayFilterFactory {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().route("hystrix_route", predicateSpec ->
                predicateSpec.path("/microservice1/**") // 设置 predicates 的匹配模式
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/microservice1/hystrix_route") // 设置拦截的指定路径
                                .stripPrefix(1)
                                .requestRateLimiter(
                                        config -> {
                                            config.setRouteId("requestratelimiter_route");
//                                            config.setKeyResolver("userKeyResolver");
                                        }
                                )
                        ).uri("lb://spring-cloud-microservice1") // 调用注册中心的 spring-cloud-microservice1 服务实例
        ).build();
    }

    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getQueryParams().getFirst("user")));
    }

}
