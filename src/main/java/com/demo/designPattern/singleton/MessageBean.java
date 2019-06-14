package com.demo.designPattern.singleton;

/**
 * @program: demo_util
 * @description: bean
 * @author: Mr.Huang
 * @create: 2019-02-18 15:34
 **/
public class MessageBean implements Message {

    private MessageBean(){

    }
    @Override
    public void printMessage() {
    System.out.println("----11----");
    }

    public static Message initialize(){
        return new MessageBean();
    }
}
