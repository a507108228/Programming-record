package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-09-20
 */
public interface EduTeacherService extends IService<EduTeacher> {

    // 分页查询讲师
    Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher);



}
