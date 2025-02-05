package com.qy.designpattern.behavioral.strategy;

// 客户端代码
public class StrategyPatternDemo {
    public static void main(String[] args) {
        // 使用加法策略
        Calculator addCalculator = new Calculator(new AddOperation());
        int addResult = addCalculator.executeOperation(5, 3);
        System.out.println("5 + 3 = " + addResult);

        // 使用减法策略
        Calculator subtractCalculator = new Calculator(new SubtractOperation());
        int subtractResult = subtractCalculator.executeOperation(5, 3);
        System.out.println("5 - 3 = " + subtractResult);

        // 使用乘法策略
        Calculator multiplyCalculator = new Calculator(new MultiplyOperation());
        int multiplyResult = multiplyCalculator.executeOperation(5, 3);
        System.out.println("5 * 3 = " + multiplyResult);
    }
}
