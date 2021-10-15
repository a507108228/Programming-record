package com.hrms.service;

import com.hrms.bean.Employee;
import com.hrms.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: a5071
 * @date: 2021/8/18 11:23
 * @description:
 */
@Service
public class EmployeeService{

    @Autowired
    EmployeeMapper employeeMapper;

    public int deleteEmpById(Integer empId){
        return employeeMapper.deleteOneById(empId);
    }

    public int updateEmpById(Integer empId, Employee employee){
        return employeeMapper.updateOneById(empId,employee);
    }

    public Employee getEmpById(Integer empId){
        return employeeMapper.selectOneById(empId);
    }

    public Employee getEmpByName(String empName){
        return employeeMapper.selectOneByName(empName);
    }

    public int getEmpCount(){
        return employeeMapper.countEmps();
    }

    public List<Employee> getEmpList(Integer offser, Integer limit){
        return employeeMapper.selectByLimitAndOffset(offser,limit);
    }







    public int addEmp(Employee employee){
        return employeeMapper.insertOne(employee);
    }

}
