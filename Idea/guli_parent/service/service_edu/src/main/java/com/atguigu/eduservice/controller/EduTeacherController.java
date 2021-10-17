package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-09-20
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin  //解决跨域
public class EduTeacherController{

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R list(){
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items", list);
    }


    // 添加讲师的接口
    @ApiOperation(value = "添加讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = teacherService.save(eduTeacher);
        if (save) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    // 逻辑删除讲师的方法
    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true)
                           @PathVariable String id){
        boolean flag = teacherService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    // 修改讲师的接口
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable String id){
        EduTeacher eduTeacher = teacherService.getById(id);
        return R.ok().data("teacher", eduTeacher);
    }

    @ApiOperation(value = "修改讲师")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean b = teacherService.updateById(eduTeacher);
        if (b){
            return R.ok();
        } else {
            return R.error();
        }
    }


    // 分页
    @ApiOperation(value = "分页")
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageList(
            @ApiParam(name = "current", value = "当前页码", readOnly = true)
            @PathVariable Long current,

            @ApiParam(name = "limit", value = "每页记录数", readOnly = true)
            @PathVariable Long limit
    ){
        Page<EduTeacher> pageParm = new Page<>(current, limit);

        try {
            int i = 10/0;
        } catch (Exception e) {
            throw new GuliException(20001, "执行自定义异常");
        }

        teacherService.page(pageParm, null);
        // 数据list集合
        List<EduTeacher> records = pageParm.getRecords();
        // 总记录数
        long total = pageParm.getTotal();

        return R.ok().data("total", total).data("rows", records);

    }


    // 分页 条件查询
    @ApiOperation(value = "条件分页")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current, @PathVariable long limit, @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        if (! StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (! StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (! StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (! StringUtils.isEmpty(end)) {
            wrapper.le("gmt_modified", end);
        }

        // 排序
        wrapper.orderByDesc("gmt_create");

        teacherService.page(pageTeacher, wrapper);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total", total).data("rows", records);
    }


}

