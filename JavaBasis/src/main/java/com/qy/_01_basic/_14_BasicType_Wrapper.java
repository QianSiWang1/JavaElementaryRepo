package com.qy._01_basic;

public class _14_BasicType_Wrapper {
    public static void main(String[] args) {
        // 自动装箱（Autoboxing）
        Integer integerObj = 100;        // 基本类型自动转换为包装类
        Double doubleObj = 3.14;
        Boolean booleanObj = true;

        // 自动拆箱（Unboxing）
        int intValue = integerObj;       // 包装类自动转换为基本类型
        double doubleValue = doubleObj;
        boolean boolValue = booleanObj;

        System.out.println("Integer对象: " + integerObj);
        System.out.println("int值: " + intValue);

        // 常用方法
        String numberStr = "123";
        int parsed = Integer.parseInt(numberStr);
        System.out.println("字符串转整数: " + parsed);

        String binary = Integer.toBinaryString(255);
        System.out.println("255的二进制: " + binary);

        // 比较
        Integer a = 100;
        Integer b = 200;
        System.out.println("比较结果: " + a.compareTo(b));

        // 数值边界
        System.out.println("int最大值: " + Integer.MAX_VALUE);
        System.out.println("int最小值: " + Integer.MIN_VALUE);
    }
}
