package com.qy.designpattern.behavioral.visitor;

// 抽象元素
interface Shape {
    void accept(Visitor visitor);
}
