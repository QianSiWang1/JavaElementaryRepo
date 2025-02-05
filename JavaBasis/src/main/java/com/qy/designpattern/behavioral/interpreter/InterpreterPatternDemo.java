package com.qy.designpattern.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

// 客户端代码
public class InterpreterPatternDemo {
    public static void main(String[] args) {
        // 上下文
        Map<String, Integer> context = new HashMap<>();
        context.put("x", 5);
        context.put("y", 3);

        // 构建表达式：x + y
        Expression expression = new AddExpression(
                new VariableExpression("x"),
                new VariableExpression("y")
        );

        // 解释并计算结果
        int result = expression.interpret(context);
        System.out.println("Result: " + result);
    }
}
