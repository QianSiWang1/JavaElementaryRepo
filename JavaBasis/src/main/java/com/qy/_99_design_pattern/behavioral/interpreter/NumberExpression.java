package com.qy._99_design_pattern.behavioral.interpreter;

import java.util.Map;

// 终结符表达式：数字
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return number;
    }
}
