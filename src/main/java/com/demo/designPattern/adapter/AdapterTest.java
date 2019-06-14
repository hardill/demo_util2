package com.demo.designPattern.adapter;

/**
 * @program: demo_util
 * @description: 适配器模式test
 * @author: Mr.Huang
 * @create: 2019-03-07 11:38
 **/
public class AdapterTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        
    }

    private static void test3() {
        Targetable absAdapter = new AbsAdapterImpl();
        Targetable absAdapter2 = new AbsAdapterImpl2();
        absAdapter.method1();
        absAdapter2.method2();

    }

    private static void test2() {
        Source source = new Source();
        AdapterImpl2 adapterImpl2 = new AdapterImpl2(source);
        adapterImpl2.method1();
        adapterImpl2.method2();
    }

    private static void test1() {
        // 测试
        Targetable source = new TargetableImpl();
        source.method1();
        source.method2();
    }
}
