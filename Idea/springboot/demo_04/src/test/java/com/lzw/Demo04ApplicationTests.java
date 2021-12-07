package com.lzw;

import com.lzw.util.JedisUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
class Demo04ApplicationTests{


    @Test
    public void test01(){
        Jedis jedis = JedisUtil.getJedisConn();

        jedis.hset("users", "age", "99");

        String hget = jedis.hget("users", "age");

        System.out.println("查询hset值：" + hget);
        jedis.close();
    }


    @Test
    public void testSub(){
        Jedis jedis = JedisUtil.getJedisConn();

        jedis.subscribe(new JedisPubSub(){
            @Override
            public void onMessage(String channel, String message){
                System.out.println("message");
                super.onMessage(channel, message);
            }
        },"订阅发布测试");

        jedis.close();
    }

    @Test
    public void testPub(){
        Jedis jedis = JedisUtil.getJedisConn();
        jedis.publish("订阅测试发布", "have a good time");

        jedis.close();
    }

}
