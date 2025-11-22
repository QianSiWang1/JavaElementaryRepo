package com.qy._99_design_pattern.behavioral.visitor;

// 抽象访问者
interface Visitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

