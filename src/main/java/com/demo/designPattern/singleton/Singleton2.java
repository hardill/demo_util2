package com.demo.designPattern.singleton;

/**
 * @program: demo_util
 * @description: 单例模式2:双重锁机制
 * @author: Mr.Huang
 * @create: 2019-03-05 15:36
 **/
public class Singleton2 {
    private static volatile Singleton2 instance;

    private Singleton2(){
    }

    public static Singleton2 getInstance(){
        if(instance==null){
            synchronized (Singleton2.class){
                if(instance==null){
                    instance= new Singleton2();
                }
            }

        }
        return instance;
    }
}
