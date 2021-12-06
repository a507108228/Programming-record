package com.lzw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzw.entity.TblBook;
import com.lzw.entity.vo.TBookQuery;
import com.lzw.mapper.TblBookMapper;
import com.lzw.service.TblBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzw.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzw
 * @since 2021-12-04
 */
@Service
public class TblBookServiceImpl extends ServiceImpl<TblBookMapper, TblBook> implements TblBookService {

    @Autowired
    private TblBookMapper bookMapper;

    @Override
    public Page<TblBook> getCourseQuery(long current, long pageSize, TblBook tblBook){

        QueryWrapper<TblBook> wrapper = new QueryWrapper<>();

        Integer id = tblBook.getId();
        String type = tblBook.getType();
        String name = tblBook.getName();
        String description = tblBook.getDescription();


        if (id != null){
            wrapper.eq("id", id);
        }

        if (! StringUtils.isEmpty(type)){
            wrapper.like("type", type);
        }

        if (! StringUtils.isEmpty(name)){
            wrapper.like("name", name);
        }

        if (! StringUtils.isEmpty(description)){
            wrapper.like("description", description);
        }

        // 排序
        wrapper.orderByAsc("id");

        Page<TblBook> pageBook = new Page<>(current, pageSize);

        bookMapper.selectPage(pageBook, wrapper);


        return pageBook;

    }
}
