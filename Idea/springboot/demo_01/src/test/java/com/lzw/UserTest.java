package com.lzw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzw.bean.Tag;
import com.lzw.mapper.TagMapper;
import com.lzw.service.TagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

/**
 * @author a5071
 * @since 2021/12/1 21:05
 * description
 */
@RunWith(SpringRunner.class)
// com.lzw  包要相同如是便不用填写@SpringBootTest(不用填写这个地方)
@SpringBootTest
public class UserTest{


    @Autowired
    private TagService tagService;

    /**
     * @author a5071
     * description junit
     */
    @Test
    public void testJunit(){
        System.out.println(1 + 1);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @author a5071
     * @description redis 存
     */
    @Test
    public void testSet(){
        redisTemplate.boundValueOps("name").set("dxx");

    }

    /**
     * @author a5071
     * @description redis 取
     */
    @Test
    public void testGet(){
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    /**
     * @author a5071
     * @description 整合mybatis
     */
    @Test
    public void testMybatis(){
        List<Tag> tags = tagService.selectAll();
        for (Tag tag : tags) {
            System.out.println(tag);
            System.out.println(" ");
        }
    }


    @Autowired
    private TagMapper tagMapper;

    /**
     * @author a5071
     * @description Mybatis-plus
     */
    @Test
    public void testMP(){

        // for (int i = 0; i < 10; i++) {
        //     int dxx = tagMapper.insert(new Tag("", "dxx", "www.baidu.com"));
        // }


        // List<Tag> tags = tagMapper.selectList(null);
        // for (Tag tag1 : tags) {
        //     System.out.println(tag1);
        // }

        // QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        // wrapper.orderByDesc("id");
        // wrapper.last("limit 10");
        // int delete = tagMapper.delete(wrapper);

        Tag tag = tagMapper.selectById("2");
        System.out.println("指定ID："+tag);
    }


}
