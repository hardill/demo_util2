package com.demo.designPattern.singleton;

/**
 * @program: demo_util
 * @description: 单例模式3:内部类模式
 * @author: Mr.Huang
 * @create: 2019-03-05 15:36
 **/
public class Singleton3 {

    private Singleton3(){
    }

    public static final Singleton3 getInstance(){
        return SingletonHolder.instance;
    }

    private static class SingletonHolder{
        public static Singleton3 instance=new Singleton3();
    }
}
