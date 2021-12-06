package com.lzw.utils;


import org.junit.Test;

import java.util.Random;
import java.util.UUID;

/**
 * @author a5071
 * @since 2021/11/27 18:32
 * description 生成指定位数的UUID
 */
public class UUIDUtil{

    public static void main(String[] args){
        String upperUUID1 = getUpperUUID();
        String lowerUUID1 = getLowerUUID();
        String upperUUID = getUpperUUID(5);
        String lowerUUID = getLowerUUID(5);
        System.out.println(upperUUID1);
        System.out.println(lowerUUID1);
        System.out.println(upperUUID);
        System.out.println(lowerUUID);
    }

    public static String getUpperUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        return uuid;
    }

    public static String getLowerUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        return uuid;
    }

    public static String getUpperUUID(int len){
        if (len <= 0) return null;

        String uuid = getUpperUUID();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < len; i++) {
            // 遍历uuid字符  将对应的字符通过append添加到str上
            str.append(uuid.charAt(i));
        }
        return str.toString();
    }

    public static String getLowerUUID(int len){
        if (len <= 0) return null;

        String uuid = getLowerUUID();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < len; i++) {
            // 遍历uuid字符  将对应的字符通过append添加到str上
            str.append(uuid.charAt(i));
        }
        return str.toString();
    }

    /**
     * @author a5071
     * description 随机生成
     */
    @Test
    public void test(){
        System.out.println(getRandomString2(5));
    }

    public static String getRandomString2(int length){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }
}
