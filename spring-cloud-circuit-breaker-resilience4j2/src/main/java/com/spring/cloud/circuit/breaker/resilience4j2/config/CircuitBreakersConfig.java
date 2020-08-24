package com.spring.cloud.circuit.breaker.resilience4j2.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * <p>Description: </p>
 *
 * @author rock.jxf
 * @date 2020/5/23 19:59
 */
@Configuration
public class CircuitBreakersConfig {
    /**
     * Configuring Resilience4J Circuit Breakers
     *
     * Default Configuration
     *
     * for all of your circuit breakers
     *
     * @return
     */
    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(3)).build()) // 超时断路
                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                .build());
    }

    /**
     * Configuring Resilience4J Circuit Breakers
     *
     * Specific Circuit Breaker Configuration
     *
     * @return
     */
    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> slowCustomizer() {
        return factory -> factory.configure(builder -> builder.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(2)).build()), "slow");
    }

//    /**
//     * Configuring Resilience4J Circuit Breakers
//     *
//     * In addition to configuring the circuit breaker that is created you can also customize the circuit breaker after it has been created but before it is returned to the caller.
//     * To do this you can use the addCircuitBreakerCustomizer method. This can be useful for adding event handlers to Resilience4J circuit breakers.
//     *
//     * @return
//     */
//    @Bean
//    public Customizer<Resilience4JCircuitBreakerFactory> slowCustomizer() {
//        return factory -> factory.addCircuitBreakerCustomizer(circuitBreaker -> circuitBreaker.getEventPublisher()
//                .onError(normalFluxErrorConsumer).onSuccess(normalFluxSuccessConsumer), "normalflux");
//    }

//    @Bean
//    public Customizer<SpringRetryCircuitBreakerFactory> defaultRetryCustomizer() {
//        return factory -> factory.configureDefault(id -> new SpringRetryConfigBuilder(id)
//                .retryPolicy(new TimeoutRetryPolicy()).build());
//    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
