package com.atguigu.eduservice.entity.vo;

import lombok.Data;

/**
 * @author a5071
 * @since 2021/10/17 20:18
 * @description:
 */
@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}
