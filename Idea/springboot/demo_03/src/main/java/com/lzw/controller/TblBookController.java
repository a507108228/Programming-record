package com.lzw.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzw.entity.TblBook;
import com.lzw.entity.vo.TBookQuery;
import com.lzw.service.impl.TblBookServiceImpl;
import com.lzw.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lzw
 * @since 2021-12-04
 */
@Api(tags = {"增删改查书籍"})
@CrossOrigin
@RestController
@RequestMapping("book")
public class TblBookController{

    @Autowired
    private TblBookServiceImpl tBService;

    @ApiOperation(value = "查询所有")
    @GetMapping("/getAll")
    public R getAll(){
        List<TblBook> list = tBService.list(null);
        return R.ok().data("list", list);
    }

    @ApiOperation("添加一条数据")
    @PostMapping("save")
    public R save(@RequestBody TblBook book){
        boolean save = tBService.save(book);
        if (save) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation("更新一条数据")
    @PutMapping("update")
    public R update(@RequestBody TblBook book){
        boolean update = tBService.updateById(book);
        if (update) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation("删除一条数据")
    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable("id") Integer id){
        boolean b = tBService.removeById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation("查询一条数据")
    @GetMapping("getOne/{id}")
    public R getOne(@PathVariable("id") Integer id){
        TblBook byId = tBService.getById(id);
        return R.ok().data("ById", byId);
    }

    // 分页
    @ApiOperation(value = "分页")
    @GetMapping("pageTBook/{current}/{pageSize}")
    public R pageList(
            @PathVariable Long current,
            @PathVariable Long pageSize,
            TblBook tblBook
    ){
        Page<TblBook> query = tBService.getCourseQuery(current, pageSize, tblBook);


        List<TblBook> records = query.getRecords();
        long total = query.getTotal();
        long size = query.getSize();
        long current1 = query.getCurrent();

        return R.ok().data("total", total).data("records", records).data("size", size).data("current", current1);

    }


    @ApiOperation("条件分页")
    @PostMapping("getPage/{current}/{pageSize}")
    public R getPage(@PathVariable("current") int current,
                     @PathVariable("pageSize") int pageSize,
                     @RequestBody(required = false) TblBook tblBook){

        Page query = tBService.getCourseQuery(current, pageSize, tblBook);

        long total = query.getTotal();
        List records = query.getRecords();
        long size = query.getSize();
        long current1 = query.getCurrent();

        return R.ok().data("total", total).data("records", records).data("size", size).data("current", current1);
    }
}

