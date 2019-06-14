package com.demo.designPattern.decorator;

/**
 * @program: demo_util
 * @description: 装饰模式
 * @author: Mr.Huang
 * @create: 2019-03-07 13:56
 **/
public class DecoratorSource implements Sourceable {
    private Source source;

    public DecoratorSource(Source source){
        super();
        this.source=source;
    }

    @Override
    public void method() {
        System.out.println("--------1---------");
        source.method();
        System.out.println("---------2-------");
    }

    public static void main(String[] args) {
        Source source = new Source();
        DecoratorSource decoratorSource = new DecoratorSource(source);
        decoratorSource.method();
    }
}
