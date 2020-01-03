package com.spring.cloud.gateway.config;

import com.spring.cloud.gateway.filter.AuthGlobalFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description: Filter Config </p>
 *
 * @author rock.jiang
 * Date 2019/12/24 17:21
 */
@Configuration
public class FilterConfig {
    @Bean
    public GlobalFilter authFilter() {
        return new AuthGlobalFilter();
    }

}
