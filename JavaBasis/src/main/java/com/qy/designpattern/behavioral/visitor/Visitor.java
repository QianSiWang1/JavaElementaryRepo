package com.qy.designpattern.behavioral.visitor;

// 抽象访问者
interface Visitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

