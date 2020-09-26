package com.kuake.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author hao
 * @create 2019-08-15 ${TIM}
 * 区别：BeanProcess接口，这个是在bean创建完成 初始化前后。
 */
public class MyBeanFactoryProcess implements BeanFactoryPostProcessor {

    public MyBeanFactoryProcess() {
        System.out.println("MyBeanFactoryProcess。。。。。。。。创建。。。");
    }

    /**
     * 所有的bean定义信息 已经被加载但是还没有被创建
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("===============postProcessBeanFactory.....................===============");
    }
}
