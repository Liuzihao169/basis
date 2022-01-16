package com.kuake.concurrent.config;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuzihao
 * @create 2022-01-15-12:31
 */
@Configuration
public class RateLimiterConfig {

    @Value("${rate.limiter:30}")
    private Integer rateLimiter;

    @Bean
    public RateLimiter rateLimiter(){
        return RateLimiter.create(rateLimiter);
    }

}
