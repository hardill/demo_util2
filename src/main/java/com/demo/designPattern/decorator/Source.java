package com.demo.designPattern.decorator;

/**
 * @program: demo_util
 * @description: 装饰模式原有类
 * @author: Mr.Huang
 * @create: 2019-03-07 13:55
 **/
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("原生方法~~~~~");
    }
}
