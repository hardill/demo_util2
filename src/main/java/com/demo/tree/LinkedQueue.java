package com.demo.tree;

import java.util.LinkedList;

public class LinkedQueue {
    private LinkedList list = new LinkedList();

    public void add(Object obj) {
        this.list.add(obj);
    }

    //获取队关元素
    public Object get() {
        return this.list.getFirst();
    }

    //出队,并删除
    public Object poll() {
        return this.list.removeFirst();
    }

    //判定为空
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    //获取当前列队长度
    public int size() {
        return this.list.size();
    }
}