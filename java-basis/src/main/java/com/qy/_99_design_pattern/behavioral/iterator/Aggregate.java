package com.qy._99_design_pattern.behavioral.iterator;

// 抽象聚合类
interface Aggregate {
    Iterator createIterator();
}
