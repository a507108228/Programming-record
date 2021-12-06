package com.lzw.service;

import com.lzw.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzw
 * @since 2021-12-05
 */
public interface PersonService extends IService<Person> {

    List<Map<String, Object>> selectAll();

    int updateOne(Person person);
}
