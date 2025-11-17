package com.qy._99_design_pattern.behavioral.interpreter;

import java.util.Map;

// 终结符表达式：变量
class VariableExpression implements Expression {
    private String variable;

    public VariableExpression(String variable) {
        this.variable = variable;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return context.getOrDefault(variable, 0);
    }
}
