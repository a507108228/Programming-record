package com.atguigu.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author a5071
 * @since 2021/10/14 16:17
 * description: 创建实体类与Excel对应关系
 */
@Data
public class SubjectData{

    @ExcelProperty(index = 0)
    private String oneSubjectName;

    @ExcelProperty(index = 1)
    private String twoSubjectName;



}
