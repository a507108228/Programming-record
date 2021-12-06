package com.lzw;

import com.lzw.entity.Person;
import com.lzw.mapper.PersonMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests{

    @Autowired
    private PersonMapper personMapper;


    @Test
    public void test(){
        List<Map<String, Object>> maps = personMapper.selectAll();
        System.out.println(maps);
    }

    /**
     * @author Administrator
     * @description
     */
    @Test
    public void test34(){
        Person person = new Person();
        person.setId(1);
        person.setName("台湾");
        int i = personMapper.updateOne(person);
        if (i > 0){
            System.out.println("成功");
        }
    }


}
