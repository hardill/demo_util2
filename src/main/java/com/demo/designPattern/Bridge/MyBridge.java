package com.demo.designPattern.Bridge;

/**
 * 桥接模式
 */
public class MyBridge extends Bridge {
    public void method(){  
        getSource().method();  
    }  
} 