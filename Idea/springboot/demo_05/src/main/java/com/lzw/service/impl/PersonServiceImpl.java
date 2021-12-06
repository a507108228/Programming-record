package com.lzw.service.impl;

import com.lzw.entity.Person;
import com.lzw.mapper.PersonMapper;
import com.lzw.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzw
 * @since 2021-12-05
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Map<String, Object>> selectAll(){
        return personMapper.selectAll();
    }

    @Override
    public int updateOne(Person person){
        return personMapper.updateOne(person);
    }
}
