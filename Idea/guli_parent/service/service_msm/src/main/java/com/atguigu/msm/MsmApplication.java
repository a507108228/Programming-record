package com.atguigu.msm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author a5071
 * @since 2021/10/31 15:59
 * description:
 */
// 取消数据源自动配置
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
// nacos
@EnableDiscoveryClient
@ComponentScan("com.atguigu")
public class MsmApplication{

    public static void main(String[] args){
        SpringApplication.run(MsmApplication.class, args);
    }
}
