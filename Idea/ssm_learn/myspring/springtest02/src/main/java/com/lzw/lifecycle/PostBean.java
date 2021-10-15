package com.lzw.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: a5071
 * @date: 2021/7/5 10:23
 * @description:
 */
public class PostBean implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
        System.out.println("初始化之前执行方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
        System.out.println("初始化之后执行的方法");
        return bean;
    }
}
