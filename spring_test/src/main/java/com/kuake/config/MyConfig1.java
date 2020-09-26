package com.kuake.config;

import com.kuake.bean.Car;
import com.kuake.bean.DogBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hao
 * @create 2019-08-07 ${TIM}
 */
@PropertySource("classpath:/db.properties")
@Configuration
public class MyConfig1 {

//    @Scope 默认是单例模式 容器启动的时候就会创建
//    @Scope(value ="prototype")//多例
//    @Lazy //懒加载 默认需要的时候创建
    @Bean(initMethod="init",destroyMethod="destory")
    public Car car(){
        return new Car();
    }

    @Bean
    public DogBeanFactory dogBeanFactory(){
        return new DogBeanFactory();
    }
}
