package com.qy.designpattern.behavioral.iterator;

// 抽象聚合类
interface Aggregate {
    Iterator createIterator();
}
