package com.atguigu.eduservice.controller.front;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author a5071
 * @since 2021/10/29 17:00
 * description:
 */
@RestController
@RequestMapping("eduservice/indexfront")
@Api(description = "用户前端页面")
@CrossOrigin
public class IndexFrontController{

    @Autowired
    private EduCourseService courseService;

    @Autowired
    private EduTeacherService teacherService;

    @Cacheable(value = "banner", key = "'select48List'")
    @ApiOperation(value = "前四名师前八课程")
    @GetMapping("index")
    public R index(){
        // 查询前8热门课程
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        wrapper.last("limit 8");

        List<EduCourse> courseList = courseService.list(wrapper);

        // 查询前4条名师
        QueryWrapper<EduTeacher> wrapper1 = new QueryWrapper<>();
        wrapper1.orderByDesc("id");
        wrapper1.last("limit 4");

        List<EduTeacher> teacherList = teacherService.list(wrapper1);

        return R.ok().data("courseList", courseList).data("teacherList", teacherList);
    }
}
