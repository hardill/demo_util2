package com.demo.designPattern.adapter;

/**
 * @program: demo_util
 * @description: 接口适配性模式实现1
 * @author: Mr.Huang
 * @create: 2019-03-07 12:23
 **/
public class AbsAdapterImpl extends AbsAdapter {
    @Override
    public void method1() {
        System.out.println("适配器方法实现1");
    }
}
