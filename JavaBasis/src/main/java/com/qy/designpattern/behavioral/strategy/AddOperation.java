package com.qy.designpattern.behavioral.strategy;

// 具体策略类：加法运算
class AddOperation implements OperationStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
