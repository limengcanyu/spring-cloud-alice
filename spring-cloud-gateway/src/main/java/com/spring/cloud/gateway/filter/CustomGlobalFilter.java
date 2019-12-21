package com.spring.cloud.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2019/12/21 17:59
 */
public class CustomGlobalFilter implements GlobalFilter, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(CustomGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.debug("custom global filter ====================================== ");

        // 从请求参数中获取token http://localhost:8780/microservice1/echo/str?token=sdfsdf
//        String token = exchange.getRequest().getQueryParams().getFirst("token");
        // 从请求header中获取token http://localhost:8780/microservice1/echo/str
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if (token == null || token.isEmpty()) {
            logger.debug("请求中token为空！");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
