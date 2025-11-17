package com.qy._99_design_pattern.behavioral.strategy;

// 具体策略类：减法运算
class SubtractOperation implements OperationStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
