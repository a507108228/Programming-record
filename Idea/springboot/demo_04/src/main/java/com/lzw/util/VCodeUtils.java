package com.lzw.util;

import redis.clients.jedis.Jedis;


/**
 * @author a5071
 * @since 2021/12/6 20:36
 * description 获取验证码 并校验
 */
public class VCodeUtils{

    public static void main(String[] args){

        String scode = verifyCode("13283835762");

        getRedisCode("13283835762", scode);

    }

    // 验证码校验
    public static void getRedisCode(String phone, String code){
        // 从redis获取验证码
        Jedis jedis = JedisUtil.getJedisConn();
        // 验证码key
        String codeKey = "VerifyCode:" + phone + ":key";

        String redisCode = jedis.get(codeKey);
        if (redisCode.equals(code)) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }


        jedis.close();
    }

    // 每个手机每天只能发送三次 放到redis中设置过期时间
    public static String verifyCode(String phone){
        // 连接redis
        Jedis jedis = JedisUtil.getJedisConn();
        // 手机发送次数key
        String countKey = "VerifyCode:" + phone + ":count";
        // 验证码key
        String codeKey = "VerifyCode:" + phone + ":key";

        // 每个手机每天只能发送三次
        String count = jedis.get(countKey);
        if (count == null) {
            jedis.setex(countKey, 24 * 60 * 60, "1");
        } else if (Integer.parseInt(count) <= 2) {
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
            System.out.println("次数超过三次，无法再次获取\n");
            jedis.close();
            return null;
        }

        // 发送验证码 放到redis中
        String vcode = UUIDUtils.getCode();
        jedis.setex(codeKey, 300, vcode);
        String s = jedis.get(codeKey);
        System.out.println("从redis中获取的验证码：" + s + "\n");
        jedis.close();
        return s;
    }

}
