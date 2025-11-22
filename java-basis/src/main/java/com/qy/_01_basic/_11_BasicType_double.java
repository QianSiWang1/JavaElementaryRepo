package com.qy._01_basic;

public class _11_BasicType_double {
    public static void main(String[] args) {
        double minValue = Double.MIN_VALUE; // 4.9E-324
        double maxValue = Double.MAX_VALUE; // 1.7976931348623157E308
        double defaultValue = 0.0d; // 默认值

        // 默认浮点类型，可以省略 d 后缀
        double price = 19.99; // 相当于 19.99d
        double largeNumber = 1.23456789012345;
        double scientific = 1.23e-8; // 科学计数法

        // 精度比 float 更高，但仍有精度问题
        double a = 0.1;
        double b = 0.2;
        double sum = a + b;
        System.out.println("0.1 + 0.2 = " + sum); // 输出：0.30000000000000004

        // 金融计算建议使用 BigDecimal
        java.math.BigDecimal decimalA = new java.math.BigDecimal("0.1");
        java.math.BigDecimal decimalB = new java.math.BigDecimal("0.2");
        java.math.BigDecimal exactSum = decimalA.add(decimalB);
        System.out.println("精确计算: " + exactSum); // 输出：0.3

        // 特殊值
        System.out.println("最大值: " + Double.MAX_VALUE);
        System.out.println("最小值: " + Double.MIN_VALUE);
        System.out.println("正无穷: " + Double.POSITIVE_INFINITY);
        System.out.println("非数字: " + Double.NaN);
    }
}
