package com.qy.designpattern.behavioral.strategy;

// 上下文类：计算器
class Calculator {
    private OperationStrategy strategy;

    public Calculator(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeOperation(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
