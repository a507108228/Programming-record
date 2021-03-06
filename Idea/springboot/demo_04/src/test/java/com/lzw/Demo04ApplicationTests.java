package com.lzw;

import com.lzw.utils.JedisUtil;
import jdk.nashorn.internal.scripts.JD;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

@RunWith(SpringRunner.class)
@SpringBootTest
class Demo04ApplicationTests{


    /**
     * @author a5071
     * @description 添加
     */
    @Test
    public void testAdd(){
        Jedis jedis = JedisUtil.getJedisConn();

        jedis.hset("users", "age", "99");
        String hget = jedis.hget("users", "age");
        System.out.println("查询hset值：" + hget);
        jedis.close();
    }

    /**
     * @author a5071
     * @description 删除
     */
    @Test
    public void testZDel(){
        Jedis jedis = JedisUtil.getJedisConn();
        // 删除hash中的一个字段
        jedis.hdel("users", "age");
        String hget = jedis.hget("users", "age");
        System.out.println("删除后：" + hget);
    }

    /**
     * @author a5071
     * @description 修改
     */
    @Test
    public void testUpd(){
        Jedis jedis = JedisUtil.getJedisConn();
        jedis.hset("users", "age", "100");
        String hget = jedis.hget("users", "age");
        System.out.println("修改后的值为：" + hget);
    }

    /**
     * @author a5071
     * @description 查询
     */
    @Test
    public void testSec(){
        Jedis jedis = JedisUtil.getJedisConn();
        String hget = jedis.hget("users", "age");
        System.out.println("查询：" + hget);
    }

    // @Test
    // public void testSub(){
    //     Jedis jedis = JedisUtil.getJedisConn();
    //
    //     jedis.subscribe(new JedisPubSub(){
    //         @Override
    //         public void onMessage(String channel, String message){
    //             System.out.println("message");
    //             super.onMessage(channel, message);
    //         }
    //     }, "订阅发布测试");
    //
    //     jedis.close();
    // }
    //
    // @Test
    // public void testPub(){
    //     Jedis jedis = JedisUtil.getJedisConn();
    //     jedis.publish("订阅测试发布", "have a good time");
    //
    //     jedis.close();
    // }

}
