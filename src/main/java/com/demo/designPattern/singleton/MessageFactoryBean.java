package com.demo.designPattern.singleton;

/**
 * @program: demo_util
 * @description: 工厂bean
 * @author: Mr.Huang
 * @create: 2019-02-18 15:33
 **/
public class MessageFactoryBean implements MessageFactory {

    private Message message=null;


    @Override
    public Message newMessage(String countryCode) {
        if (message == null) {
            synchronized (message) {
                if (message == null) {
                    message =MessageBean.initialize();
                }
            }
        }
        return message;
    }
}
