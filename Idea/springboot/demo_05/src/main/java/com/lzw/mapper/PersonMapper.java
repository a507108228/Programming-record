package com.lzw.mapper;

import com.lzw.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lzw
 * @since 2021-12-05
 */
@Repository
public interface PersonMapper extends BaseMapper<Person> {

    List<Map<String, Object>> selectAll();

    int updateOne(Person person);
}
