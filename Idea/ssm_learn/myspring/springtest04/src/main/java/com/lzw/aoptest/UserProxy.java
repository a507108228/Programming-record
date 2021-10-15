package com.lzw.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: a5071
 * @date: 2021/7/6 16:50
 * @description:
 */
@Component("userProxy")
@Aspect
public class UserProxy{
    // 2 add 方法的前置通知
    @Before(value = "execution(* com.lzw.aoptest.User.add(..))")
    public void before(){
        System.out.println("before...");
    }

    @After(value = "execution(* com.lzw.aoptest.User.add(..))")
    public void after(){
        System.out.println("after...");
    }

    // 有异常才执行
    @AfterThrowing(value = "execution(* com.lzw.aoptest.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }

    @Around(value = "execution(* com.lzw.aoptest.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("around之前...");
        proceedingJoinPoint.proceed();
        System.out.println("around之后...");
    }

    @AfterReturning(value = "execution(* com.lzw.aoptest.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturnning...");
    }


}
