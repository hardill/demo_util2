package com.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    // 课程编码
    private String courseCode;
    // 课程Id
    private Integer courseId;
    // 课程名称
    private String courseName;
    // 老师名称
    private String teacherName;
}