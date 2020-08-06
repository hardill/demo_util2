package com.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @program: demo_util
 * @description: 测试bean
 * @author: Mr.Huang
 * @create: 2019-04-16 14:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @NotNull
    @Size(min = 1,message = "param name is null")
    private String name;
    @NotNull
    @Min(value = 1,message = "年龄小于1")
    private Integer age;
}
