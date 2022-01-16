package com.kuake.concurrent.controller;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzihao
 * @create 2022-01-15-12:30
 * 限流
 */
@RestController
@Slf4j
public class RateLimiterController {

    @Autowired
    RateLimiter rateLimiter;

    /**
     * 非阻塞限流接口,
     * @return
     */
    @GetMapping("/tryAcquire")
    public String tryAcquire() {

        log.info("非阻塞限流接口");

        /**
         * 尝试获取令牌，如未获取到则直接失败(也可以设置try的时间)
         */
        if (rateLimiter.tryAcquire()) {
            log.info("通过.../ 数率为{}", rateLimiter.getRate());
            return "success";
        }
        return "fail";

    }

    /**
     * 阻塞接口
     */

    @GetMapping("/acquire")
    public String acquire() {
        rateLimiter.acquire();
        log.info("通过流接口....... -流量：{}", rateLimiter.getRate());

        return "success";
    }
}
