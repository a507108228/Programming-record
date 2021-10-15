package com.atguigu.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author a5071
 * @since 2021/10/13 17:41
 * description:
 */
// 方法二不配置数据源
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan({"com.atguigu"})
public class OssApplication{

    public static void main(String[] args){
        SpringApplication.run(OssApplication.class, args);
    }
}
