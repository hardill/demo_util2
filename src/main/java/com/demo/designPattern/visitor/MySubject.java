package com.demo.designPattern.visitor;

/**
 * 访问者模式
 */
public class MySubject implements Subject {
  
    @Override  
    public void accept(Visitor visitor) {  
        visitor.visit(this);  
    }  
  
    @Override  
    public String getSubject() {  
        return "love";  
    }  
}  