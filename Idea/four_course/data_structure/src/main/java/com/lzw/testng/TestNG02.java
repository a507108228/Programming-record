package com.lzw.testng;

import org.testng.annotations.*;

/**
 * @author: a5071
 * @date: 2021/9/15 15:52
 * @description:
 */
public class TestNG02{


    @Test
    public void method1(){
        System.out.println(4%8);
        System.out.println("----------Test");
    }


    @BeforeSuite
    public void method2(){
        System.out.println(" ---------BeforeSuite");
    }

    @AfterSuite
    public void method3(){
        System.out.println(" ---------AfterSuite");
    }

    @BeforeClass
    public void method4(){
        System.out.println(" ---------BeforeClas");
    }


    @AfterClass
    public void method5(){
        System.out.println(" ---------AfterClass");
    }

    @BeforeMethod
    public void method6(){
        System.out.println("-----------BeforeMethod");
    }

    @AfterMethod
    public void method7(){
        System.out.println("-----------AfterMethod");
    }


}




