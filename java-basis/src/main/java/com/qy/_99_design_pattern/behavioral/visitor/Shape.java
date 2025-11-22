package com.qy._99_design_pattern.behavioral.visitor;

// 抽象元素
interface Shape {
    void accept(Visitor visitor);
}
