package com.lzw.testng;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


/**
 * @author: a5071
 * @date: 2021/9/15 15:14
 * @description:
 */
public class TestNG{

    @BeforeTest    // 标记指定所有测试进行前呼叫此 method

    public void beforeAllTest(){

        System.out.println("Before All Test");

    }

    @BeforeMethod    // 标记指定每个测试进行前呼叫此 method

    public void setUp() {

        System.out.println("Before Each Test Method");

    }

    @Test(groups = { "group1" })    // 标记为测试程式，并为分组 group1

    public void group1Test() {

        System.out.println("Group 1");

    }

    @Test(groups = { "group2" })    // 标记为测试程式，并为分组 group2

    public void group2Test() {

        System.out.println("Group 2");

    }

    @Test(groups = { "group3" })    // 标记为测试程式，并为分组 group3

    public void group3Test() {

        System.out.println("Group 3");

    }

    @Test                          //测试两个数是否相等
    public void add()
    {
        assertEquals(6,6);
    }

    Login log = new Login();
    boolean tt =log.logintest("test", "test") ;

    @Test                         //测试登录方法是否正确
    public void testLogin()
    {
        assertTrue(tt);
    }


    @AfterMethod   // 标记指定每个测试进行后呼叫此 method

    public void tearDown(){

        System.out.println("After Each Test Method");

    }



    @AfterTest   // 标记指定所有测试进行后呼叫此 method

    public void afterAllTest(){

        System.out.println("After All Test");

    }



}
