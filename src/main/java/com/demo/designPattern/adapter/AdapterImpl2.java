package com.demo.designPattern.adapter;

/**
 * @program: demo_util
 * @description: 对象的适配器模式类
 * @author: Mr.Huang
 * @create: 2019-03-07 11:38
 **/
public class AdapterImpl2 implements Targetable{
    private Source source;

    public AdapterImpl2(Source source){
        super();
        this.source=source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is adapter2");
    }
}
