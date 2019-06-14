package com.demo.designPattern.singleton;

/**
 * @program: demo_util
 * @description: 单例模式1:懒汉式
 * @author: Mr.Huang
 * @create: 2019-03-05 15:36
 **/
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1(){

    }
    public static synchronized Singleton1 getInstance(){
        if(instance==null){
            instance= new Singleton1();
        }
        return instance;
    }
}
