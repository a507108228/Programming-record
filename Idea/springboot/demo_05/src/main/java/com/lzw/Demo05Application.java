package com.lzw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.lzw.mapper")
public class Demo05Application{

    public static void main(String[] args){

        ApplicationContext run = SpringApplication.run(Demo05Application.class, args);

        System.out.println(run);

    }

}
