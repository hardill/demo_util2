package com.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student
{
    // 身份ID
    private Long id;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 电话
    private String mobile;
    // 地址
    //private String address;
    // 地址
    private Address address;
    // 课程集合
    private List<Course> courses;
    private String entrollmentDate;
}