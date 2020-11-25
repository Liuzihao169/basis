package com.kuake.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author hao
 * @create 2019-08-15 ${TIM}
 */
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {


    public MyBeanDefinitionRegistryPostProcessor() {
        System.out.println("...该方法创建...");
    }

    /**
     * 在所有bean定义信息将要被加载，bean实例还未创建的；
     * 优先于postProcessBeanFactory
     * @param registry
     * @throws BeansException
     *
     * 先执行postProcessBeanDefinitionRegistry
     * 再执行postProcessBeanFactory
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinition beanDefinition = new RootBeanDefinition(Dog.class);
        registry.registerBeanDefinition("mydog",beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory....MyBeanDefinitionRegistryPostProcessor....");
    }
}
