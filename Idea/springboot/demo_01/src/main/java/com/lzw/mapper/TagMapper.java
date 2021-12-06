package com.lzw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzw.bean.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author a5071
 * @since 2021/12/1 21:37
 * description
 */
@Repository
public interface TagMapper extends BaseMapper<Tag>{

    List<Tag> selectAll();
}
