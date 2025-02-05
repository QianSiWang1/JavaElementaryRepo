package com.qy.designpattern.behavioral.strategy;

// 具体策略类：乘法运算
class MultiplyOperation implements OperationStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
