package com.lzw.leetcode;

import java.util.HashMap;

/**
 * @author a5071
 * @since 2022/2/7 10:12
 * description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LC_03{

    public static void main(String[] args){
        LC_03 lc_03 = new LC_03();
        System.out.println(lc_03.lengthOfLongestSubstring("abcabcdabcdef"));
    }

    public int lengthOfLongestSubstring(String s){
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        // 最长子串长度 与 滑动窗口左指针
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // charAt() 方法用于返回指定索引处的字符。索引范围为
            if (map.containsKey(s.charAt(i))) {
                // map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移
                // map.get('a')=0,因为map中只有第一个a的下标，然后更新left指针到原来left的的下一位
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 更新map映射下标
            map.put(s.charAt(i), i);
            // 比较两个参数大小
            max = Math.max(max, i - left + 1);
        }
        return max;
    }



}
