package com.demo.designPattern.adapter;

/**
 * @program: demo_util
 * @description: 类的适配器模式实现类
 * @author: Mr.Huang
 * @create: 2019-03-07 11:34
 */
public class TargetableImpl extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("hello adapter2");
    }

}
