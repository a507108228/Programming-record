package com.atguigu.servicebase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author a5071
 * @since 2021/9/21 9:04
 * description: 自动填充创建时间 更新时间
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler{

    @Override
    public void insertFill(MetaObject metaObject){
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject){
        this.setFieldValByName("gmtModified", new Date(), metaObject);

    }
}
