package com.qy._01_basic;

public class _08_BasicType_int {
    public static void main(String[] args) {
        int minValue = Integer.MIN_VALUE; // -2147483648
        int maxValue = Integer.MAX_VALUE; // 2147483647
        int defaultValue = 0; // 默认值

        // 最常见的整数类型
        int age = 25;
        int count = 100;
        int temperature = -10;

        // 不同进制的表示
        int decimal = 100;       // 十进制
        int binary = 0b1100100;  // 二进制
        int octal = 0144;        // 八进制
        int hexadecimal = 0x64;  // 十六进制

        System.out.println("十进制: " + decimal);
        System.out.println("二进制: " + binary);
        System.out.println("八进制: " + octal);
        System.out.println("十六进制: " + hexadecimal);

        // 下划线分隔（提高可读性）
        int million = 1_000_000;
        //int creditCard = 1234_5678_9012_3456L; // 注意：这是long类型

        // 运算注意事项
        int result = Integer.MAX_VALUE + 1; // 整数溢出
        System.out.println("溢出结果: " + result); // 输出：-2147483648
    }
}
