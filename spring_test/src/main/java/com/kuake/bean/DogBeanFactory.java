package com.kuake.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author hao
 * @create 2019-08-07 ${TIM}
 * 这个是一个 bean的工厂 用于专门创建bean
 */
public class DogBeanFactory implements FactoryBean<Dog> {
    @Override
    public Dog getObject() throws Exception {
        System.out.println("..DogBeanFactory...og");
        return new Dog();
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }

    /**
     * 指定是否为单例 fasle多例 true 单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
