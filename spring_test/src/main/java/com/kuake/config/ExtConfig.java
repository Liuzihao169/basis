package com.kuake.config;

import com.kuake.bean.MyBeanDefinitionRegistryPostProcessor;
import com.kuake.bean.MyBeanFactoryProcess;
import com.kuake.bean.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hao
 * @create 2019-08-15 ${TIM}
 */
@Configuration
public class ExtConfig {
    @Bean
    public MyBeanDefinitionRegistryPostProcessor myBeanDefinitionRegistryPostProcessor(){
        return  new MyBeanDefinitionRegistryPostProcessor();
    }

    @Bean
    public MyBeanFactoryProcess myBeanFactoryProcess(){
        return new MyBeanFactoryProcess();
    }
    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
