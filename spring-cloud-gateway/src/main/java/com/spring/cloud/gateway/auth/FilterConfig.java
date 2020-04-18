package com.spring.cloud.gateway.auth;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

/**
 * <p>Description: Filter Config </p>
 *
 * @author rock.jiang
 * Date 2019/12/24 17:21
 */
@Configuration
public class FilterConfig {
//    @Bean
//    public GlobalFilter authFilter() {
//        return new AuthGlobalFilter();
//    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("rewrite_request_obj", predicateSpec ->
                        predicateSpec.path("/microservice1/modifyRequestBody").filters(gatewayFilterSpec ->
                                gatewayFilterSpec.prefixPath("microservice1")
                                        .modifyRequestBody(
                                                String.class,
                                                Hello.class,
                                                MediaType.APPLICATION_JSON_VALUE,
                                                (serverWebExchange, s) -> Mono.just(new Hello(s.toLowerCase()))
                                        )
                        ).uri("lb://spring-cloud-microservice1")
                ).build();
    }

    static class Hello {
        String message;

        public Hello() {
        }

        public Hello(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
