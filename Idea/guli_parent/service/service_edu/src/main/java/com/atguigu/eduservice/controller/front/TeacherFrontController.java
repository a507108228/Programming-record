package com.atguigu.eduservice.controller.front;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author a5071
 * @since 2021/11/7 15:04
 * description: 前台系统教师、课程
 */
@Api(description = "前台系统教师")
@RestController
@RequestMapping("eduservice/teacherfront")
@CrossOrigin
public class TeacherFrontController{

    @Autowired
    private EduTeacherService teacherService;

    @Autowired
    private EduCourseService courseService;

    @ApiOperation(value = "分页查询讲师")
    @PostMapping("getTeacherFrontList/{page}/{limit}")
    public R getTeacherFrontList(@PathVariable long page, @PathVariable long limit){

        Page<EduTeacher> pageTeacher = new Page<>(page, limit);

        Map<String, Object> map = teacherService.getTeacherFrontList(pageTeacher);
        return R.ok().data(map);
    }


    @ApiOperation(value = "讲师详情查询")
    @GetMapping("getTeacherFrontInfo/{teacherId}")
    public R getTeacherFrontInfo(@PathVariable String teacherId){

        // 根据讲师id查询讲师的基本信息
        EduTeacher eduTeacher = teacherService.getById(teacherId);

        // 根据讲师id查询课程
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id", teacherId);
        // 注入courseService 通过course中的讲师id查询课程
        List<EduCourse> courseList = courseService.list(wrapper);

        return R.ok().data("teacher", eduTeacher).data("courseList", courseList);
    }
}
