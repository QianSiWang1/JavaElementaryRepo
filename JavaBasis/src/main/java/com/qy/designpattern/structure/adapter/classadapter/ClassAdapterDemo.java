package com.qy.designpattern.structure.adapter.classadapter;

// 客户端代码
public class ClassAdapterDemo {
    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.request();
    }
}
