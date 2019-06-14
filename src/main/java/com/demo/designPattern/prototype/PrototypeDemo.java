package com.demo.designPattern.prototype;

/**
 * @program: demo_util
 * @description: 原型模式简单版
 * @author: Mr.Huang
 * @create: 2019-03-05 17:59
 **/
public class PrototypeDemo implements Cloneable {
    @Override
    protected PrototypeDemo clone() throws CloneNotSupportedException {
        return (PrototypeDemo)super.clone();
    }

  public static void main(String[] args) {
    //深入克隆 二进制

  }
}
