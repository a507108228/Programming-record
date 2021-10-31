package com.atguigu.msm.service;


import java.util.Map;

/**
 * @author a5071
 * @since 2021/10/31 16:01
 * description:
 */
public interface MsmService{
    boolean send(Map<String, Object> param, String phone);
}
