package com.demo.designPattern.visitor;

public interface Subject {
    void accept(Visitor visitor);

    String getSubject();
}  