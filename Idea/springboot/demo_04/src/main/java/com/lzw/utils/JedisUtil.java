package com.lzw.util;

import redis.clients.jedis.Jedis;

/**
 * @author a5071
 * @since 2021/12/6 21:08
 * description Jedis连接Redis
 */
public class JedisUtil{

    public static Jedis getJedisConn(){
        Jedis jedis = new Jedis("121.41.40.20",6380);
        jedis.auth("Pwds.1308tgb");

        return jedis;
    }

}
