package com.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    // 身份ID
    private Long id;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 电话
    private String mobile;
    private String counsellor;
    // 地址
   // private String addr;
    // 地址
    private AddressDTO address;
    // 课程集合
    private List<CourseDTO> courses;
    private Date entrollmentDate;
}