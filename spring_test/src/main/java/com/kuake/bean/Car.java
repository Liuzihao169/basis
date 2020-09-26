package com.kuake.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author hao
 * @create 2019-08-07 ${TIM}
 */
public class Car implements InitializingBean,DisposableBean,EmbeddedValueResolverAware {
    public Car() {
        System.out.println("====================创建car=================");
    }

    @PostConstruct
    public void post(){
        System.out.println("======================@PostConstruct====================");
    }

    @PreDestroy
    public void pre(){
        System.out.println("========================@PreDestroy===============================");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=========================InitializingBean接口========afterPropertiesSet===============");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("=======================DisposableBean接口===========destroy===========");
    }

    public void init(){
        System.out.println("==============================init方法=========================");
    }

    public void destory(){
        System.out.println("===========================destory方法=============================");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("====================setEmbeddedValueResolver=======================");
    }
}
