package com.lzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author a5071
 * @since 2021/11/19 15:10
 * description 主程序类
 */
@SpringBootApplication
public class Demo01Application{

    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(Demo01Application.class, args);

        // String[] names = run.getBeanDefinitionNames();
        // for (String name :
        //         names) {
        //     System.out.println(name);
        // }
    }
}
