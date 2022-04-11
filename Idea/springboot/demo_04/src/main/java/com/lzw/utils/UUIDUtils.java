package com.lzw.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author a5071
 * @since 2021/12/4 23:05
 * description
 */
public class UUIDUtils{

    public static String getUpperUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        return uuid;
    }

    public static String getLowerUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        return uuid;
    }

    public static String getUpperUUID(int len){
        if (len <= 0){ return null; }

        String uuid = getUpperUUID();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < len; i++) {
            // 遍历uuid字符  将对应的字符通过append添加到str上
            str.append(uuid.charAt(i));
        }
        return str.toString();
    }

    public static String getLowerUUID(int len){
        if (len <= 0) {return null;}

        String uuid = getLowerUUID();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < len; i++) {
            // 遍历uuid字符  将对应的字符通过append添加到str上
            str.append(uuid.charAt(i));
        }
        return str.toString();
    }

    // 生成六位的验证码
    public static String getCode(){
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            // 10以内的值
            int i1 = random.nextInt(10);
            code += i1;
        }
        return code;
    }

}
