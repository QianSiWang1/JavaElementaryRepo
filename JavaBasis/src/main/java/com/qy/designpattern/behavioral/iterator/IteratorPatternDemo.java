package com.qy.designpattern.behavioral.iterator;

// 客户端代码
public class IteratorPatternDemo {
    public static void main(String[] args) {
        List list = new List();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        Iterator iterator = list.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
