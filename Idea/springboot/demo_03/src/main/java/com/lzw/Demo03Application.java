package com.lzw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author a5071
 * @since 2021/12/4 15:24
 * description
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.lzw.mapper"})
public class Demo03Application{

    public static void main(String[] args){
        ApplicationContext run = null;
        try {
            run = SpringApplication.run(Demo03Application.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(run);
    }
}
