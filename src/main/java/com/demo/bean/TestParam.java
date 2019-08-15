package com.demo.bean;

import lombok.Data;

import javax.ws.rs.QueryParam;

/**
 * @program: demo_util
 * @description:
 * @author: Mr.Huang
 * @create: 2019-06-20 17:05
 **/
@Data
public class TestParam {
    @QueryParam("name")
    private String name;
    @QueryParam("age")
    private Integer[] age;
}
