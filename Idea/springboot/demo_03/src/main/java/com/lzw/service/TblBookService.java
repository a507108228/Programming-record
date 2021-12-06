package com.lzw.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzw.entity.TblBook;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzw.entity.vo.TBookQuery;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzw
 * @since 2021-12-04
 */
public interface TblBookService extends IService<TblBook> {

    // 条件分页
    Page<TblBook> getCourseQuery(long current, long pageSize, TblBook tblBook);



}
