package com.qy._01_basic;

public class _07_BasicType_short {
    public static void main(String[] args) {
        short minValue = -32768;
        short maxValue = 32767;
        short defaultValue = 0; // 默认值

        // 在现代Java中较少使用
        // 主要用于兼容旧代码或特定场景

        // 自动类型转换
        short s = 100;
        int i = s; // short自动转换为int

        // 强制类型转换
        int largeInt = 32768;
        // short converted = largeInt; // 编译错误：需要强制转换
        short converted = (short) largeInt; // 可能丢失数据
        System.out.println("转换后: " + converted); // 输出：-32768（溢出）
    }
}
