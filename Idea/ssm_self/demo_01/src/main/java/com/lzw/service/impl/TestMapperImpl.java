package com.lzw.service.impl;

import com.lzw.bean.Tag;
import com.lzw.mapper.TestMapper;
import com.lzw.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a5071
 * @since 2021/11/18 19:01
 * description
 */
@Service
public class TestMapperImpl implements TestService{

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Tag> getAllTags(){
        return testMapper.getAllTags();
    }
}
