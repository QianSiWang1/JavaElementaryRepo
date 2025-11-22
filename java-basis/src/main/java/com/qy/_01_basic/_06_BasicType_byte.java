package com.qy._01_basic;

public class _06_BasicType_byte {
    public static void main(String[] args) {
        byte minValue = -128;
        byte maxValue = 127;
        byte defaultValue = 0; // 默认值

        // 常见用途：处理二进制数据
        byte[] buffer = new byte[1024]; // 用于I/O操作的缓冲区

        // 位运算
        byte flags = 0b00101101; // 二进制表示
        System.out.println("二进制值: " + Integer.toBinaryString(flags & 0xFF));

        // 注意事项：超出范围会导致编译错误
        // byte error = 128; // 编译错误：超出范围
    }
}
