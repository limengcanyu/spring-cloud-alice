package com.spring.cloud.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * <p>Description: Auth Global Filter </p>
 *
 * @author rock.jiang
 * Date 2019/12/21 17:59
 */
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(AuthGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.debug("Auth Global Filter ====================================== ");
        logger.debug("当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());

        ServerHttpRequest request = exchange.getRequest();
        logger.debug("请求对象类型: {}", request.getClass());

        Map<String, Object> requestAttributes = exchange.getAttributes();
        logger.debug("请求属性: {}", requestAttributes);

//        // 从请求参数中获取token http://localhost:8780/microservice1/echo/str?token=sdfsdf
//        String token = request.getQueryParams().getFirst("token");
//        // 从请求header中获取token http://localhost:8780/microservice1/echo/str
//        String token = request.getHeaders().getFirst("token");
//        if (token == null || token.isEmpty()) {
//            logger.debug("请求中token为空！");
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }

//        // 获取请求Body
//        Flux<DataBuffer> bodyFlux = request.getBody();
//        bodyFlux.subscribe(dataBuffer -> {
//            logger.debug("当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());
//            logger.debug("dataBuffer: {}", dataBuffer);
//
//            byte[] bytes = new byte[dataBuffer.readableByteCount()];
//            dataBuffer.read(bytes);
//            DataBufferUtils.release(dataBuffer);
//            String bodyString = new String(bytes, StandardCharsets.UTF_8);
//            logger.debug("bodyString: {}", bodyString);
//        });

        logger.debug("当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

}
