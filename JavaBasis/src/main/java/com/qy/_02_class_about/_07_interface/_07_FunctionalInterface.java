package com.qy._02_class_about._07_interface;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
public interface _07_FunctionalInterface {
    public static void main(String[] args) {
        // 使用 Lambda 表达式
        _07_FunctionalInterface adder = (a, b) -> a + b;
        _07_FunctionalInterface multiplier = (a, b) -> a * b;

        System.out.println("加法: " + adder.calculate(5, 3));      // 8
        System.out.println("乘法: " + multiplier.calculate(5, 3)); // 15

        // 使用方法引用
        //_07_FunctionalInterface power = Math::pow; // 编译错误，返回值类型不匹配
        _07_FunctionalInterface max = Math::max;   // 正确

        // 在集合操作中使用
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(n -> System.out.println(n * n));
    }
    int calculate(int a, int b);

    // 可以有多个默认方法
    default void printResult(int result) {
        System.out.println("结果: " + result);
    }

    // 可以有静态方法
    static _07_FunctionalInterface create() {
        return Integer::sum;
    }
}