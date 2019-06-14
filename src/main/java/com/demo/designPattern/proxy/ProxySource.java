package com.demo.designPattern.proxy;

import com.demo.designPattern.decorator.Source;
import com.demo.designPattern.decorator.Sourceable;

/**
 * @program: demo_util
 * @description: 装饰模式
 * @author: Mr.Huang
 * @create: 2019-03-07 13:56
 **/
public class ProxySource implements Sourceable {
    private Source source;

    public ProxySource(){
        super();
        this.source=new Source();
    }

    @Override
    public void method() {
        bef();
        source.method();
        aft();
    }

    private void bef() {
        System.out.println("--------bef---------");
    }
    private void aft() {
        System.out.println("--------aft---------");
    }

    public static void main(String[] args) {
        ProxySource decoratorSource = new ProxySource();
        decoratorSource.method();
    }
}
