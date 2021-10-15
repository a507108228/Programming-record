package com.hrms.test;

import com.hrms.bean.Employee;
import com.hrms.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: a5071
 * @date: 2021/8/10 16:40
 * @description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class EmployeeMapperTest{

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;

    @Test
    public void test(){
        int insert = employeeMapper.insertOne(new Employee(null, "李梓玮", "2280@qq.com", "男", 3));
        System.out.println(insert);
    }

    /**
     * @author: a5071
     * @description:
     */
    @Test
    public void testUpdate(){
        Employee employee = new Employee(612, "李名", "2208@qq.com", "女", 3);
        int i = employeeMapper.updateOneById(612, employee);
        System.out.println(i);

    }
}
