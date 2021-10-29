package com.atguigu.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author a5071
 * @since 2021/10/27 19:28
 * description:
 */
// nacos
@EnableDiscoveryClient
@SpringBootApplication
// 指定扫描位置
@ComponentScan({"com.atguigu"})
// 扫描自定义mapper.xml
@MapperScan("com.atguigu.cms.mapper")
public class CmsApplication{
    public static void main(String[] args){

        SpringApplication.run(CmsApplication.class, args);
    }
}
