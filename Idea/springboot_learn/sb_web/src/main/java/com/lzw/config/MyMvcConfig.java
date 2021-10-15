package com.lzw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author: a5071
 * @date: 2021/8/24 16:37
 * @description:
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer{

    // 自定义视图解析器
    // @Bean
    // public ViewResolver myViewResolver(){
    //     return  new MyViewResolver();
    // }
    //
    // public static class MyViewResolver implements ViewResolver{
    //
    //     @Override
    //     public View resolveViewName(String viewName, Locale locale) throws Exception{
    //         return null;
    //     }
    // }


    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addRedirectViewController("/lzw","test");

    }
}
