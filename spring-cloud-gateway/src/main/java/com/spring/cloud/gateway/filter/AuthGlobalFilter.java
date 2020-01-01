package com.spring.cloud.gateway.filter;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rx.internal.reactivestreams.SubscriberAdapter;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

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

//        // 从请求参数中获取token http://localhost:8780/microservice1/echo/str?token=sdfsdf
//        String token = request.getQueryParams().getFirst("token");
//        // 从请求header中获取token http://localhost:8780/microservice1/echo/str
//        String token = request.getHeaders().getFirst("token");
//        if (token == null || token.isEmpty()) {
//            logger.debug("请求中token为空！");
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }

        Flux<DataBuffer> bodyFlux = request.getBody();

        Consumer<DataBuffer> consumer = dataBuffer -> {
            logger.debug("当前线程ID: {} 线程名称: {}", Thread.currentThread().getId(), Thread.currentThread().getName());
            logger.debug("dataBuffer: {}", dataBuffer);

            byte[] bytes = new byte[dataBuffer.readableByteCount()];
            dataBuffer.read(bytes);
            DataBufferUtils.release(dataBuffer);
            String bodyString = new String(bytes, StandardCharsets.UTF_8);
            logger.debug("bodyString: {}", bodyString);
        };

        Disposable disposable = bodyFlux.subscribe(consumer);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

}
