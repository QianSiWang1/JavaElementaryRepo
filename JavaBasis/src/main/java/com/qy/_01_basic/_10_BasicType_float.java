package com.qy._01_basic;

public class _10_BasicType_float {
    public static void main(String[] args) {
        float minValue = Float.MIN_VALUE; // 1.4E-45
        float maxValue = Float.MAX_VALUE; // 3.4028235E38
        float defaultValue = 0.0f; // 默认值

        // 必须使用 f 或 F 后缀
        float price = 19.99f;
        float temperature = -5.5f;
        float scientific = 1.23e-4f; // 科学计数法

        // 特殊值
        float positiveInfinity = Float.POSITIVE_INFINITY;
        float negativeInfinity = Float.NEGATIVE_INFINITY;
        float nan = Float.NaN; // Not a Number

        System.out.println("正无穷: " + positiveInfinity);
        System.out.println("负无穷: " + negativeInfinity);
        System.out.println("非数字: " + nan);

        // 精度问题
        float a = 0.1f;
        float b = 0.2f;
        float sum = a + b;
        System.out.println("0.1 + 0.2 = " + sum); // 输出：0.30000000000000004

        // 比较浮点数应该使用误差范围
        float expected = 0.3f;
        float epsilon = 0.0001f; // 误差范围
        if (Math.abs(sum - expected) < epsilon) {
            System.out.println("在误差范围内相等");
        }
    }
}
