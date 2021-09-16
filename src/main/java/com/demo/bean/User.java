package com.demo.bean;

import lombok.Data;

@Data
public class User
{
    // 身份ID
    private Long id=1L;
    // 姓名
    private String name="test";
    private String password="123456";
    // 年龄
    private Integer age;
    // 电话
    private String mobile;
    // 地址
    private Address address;

}
