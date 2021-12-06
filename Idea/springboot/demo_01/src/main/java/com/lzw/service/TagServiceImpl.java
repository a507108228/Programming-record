package com.lzw.service;

import com.lzw.bean.Tag;
import com.lzw.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a5071
 * @since 2021/12/1 21:37
 * description
 */
@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> selectAll(){

        return tagMapper.selectAll();
    }
}
