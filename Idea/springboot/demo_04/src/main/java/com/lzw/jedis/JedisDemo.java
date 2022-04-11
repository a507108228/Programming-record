package com.lzw.jedis;

import com.lzw.utils.JedisUtil;
import com.lzw.utils.UUIDUtils;
import redis.clients.jedis.Jedis;


/**
 * @author a5071
 * @since 2021/12/6 20:36
 * description 测试Java代码操作redis 验证码
 */
public class JedisDemo{

    public static void main(String[] args){
        // 模拟验证码的发送
        verifyCode("13283835762");

        // 验证
        // getRedisCode("13283835762","235695");

    }

    // 验证码校验
    public static void getRedisCode(String phone, String code){
        // 从redis获取验证码
        Jedis jedis = JedisUtil.getJedisConn();
        String codeKey = "VerifyCode" + phone + ":code";
        String redisCode = jedis.get(codeKey);
        // 判断
        if (redisCode.equals(code)){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }

        jedis.close();
    }

    // 每个手机每天只能发送三次 放到redis中设置过期时间
    public static void verifyCode(String phone){
        // 连接redis
        Jedis jedis = JedisUtil.getJedisConn();
        // 手机发送次数key
        String countKey = "VerifyCode" + phone + ":count";
        // 验证码key
        String codeKey = "VerifyCode" + phone + ":code";

        // 每个手机每天只能发送三次
        String count = jedis.get(countKey);
        if (count == null) {
            // 表示第一次发送 设置发送次数为1
            jedis.setex(countKey, 24 * 60 * 60, "1");
        } else if (Integer.parseInt(count) <= 2) {
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
            System.out.println("今天发送已超过三次");
            jedis.close();
            // 超过三次后 必须返回不然还会继续发送验证码
            return;
        }

        // 发送验证码 放到redis中
        String vcode = UUIDUtils.getCode();
        jedis.setex(codeKey, 120, vcode);
        System.out.println(vcode);
        jedis.close();
    }

}
