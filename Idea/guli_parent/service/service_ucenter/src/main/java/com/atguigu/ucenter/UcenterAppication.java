package com.atguigu.ucenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author a5071
 * @since 2021/10/31 18:08
 * description:
 */
// nacos
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.atguigu")
// mapper扫描
@MapperScan("com.atguigu.ucenter.mapper")
public class UcenterAppication{

    public static void main(String[] args){
        SpringApplication.run(UcenterAppication.class, args);
    }
}
