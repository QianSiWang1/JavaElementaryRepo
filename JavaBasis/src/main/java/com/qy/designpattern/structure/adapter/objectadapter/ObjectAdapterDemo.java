package com.qy.designpattern.structure.adapter.objectadapter;

// 客户端代码
public class ObjectAdapterDemo {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}
