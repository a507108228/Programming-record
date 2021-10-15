package com.atguigu.mpdemo1010.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.util.Date;


/**
 * @author: a5071
 * @date: 2021/9/19 9:06
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(type = IdType.ID_WORKER) // mp自带策略，生成19位值 数字类型使用这种 如int long

    //@TableId(type = IdType.ID_WORKER.ID_WORKER_STR) // mp自带策略，生成19位值,字符串类型使用这种策略
    private Long id;
    private String name;
    private Integer age;
    private String email;

    //create_time
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    //update_time
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;//版本号

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
