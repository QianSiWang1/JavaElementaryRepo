package com.qy._01_basic;

public class _09_BasicType_long {
    public static void main(String[] args) {
        long minValue = Long.MIN_VALUE; // -9223372036854775808L
        long maxValue = Long.MAX_VALUE; // 9223372036854775807L
        long defaultValue = 0L; // 默认值

        // 必须使用 L 或 l 后缀（推荐使用 L，避免与数字1混淆）
        long bigNumber = 123456789012345L;
        long smallNumber = 100L;

        // 时间戳常用 long 类型
        long timestamp = System.currentTimeMillis();
        System.out.println("当前时间戳: " + timestamp);

        // 大数值计算
        long population = 7_900_000_000L; // 世界人口

        // 自动类型转换
        int intValue = 100;
        long longValue = intValue; // int 自动转换为 long

        // 强制类型转换（可能丢失精度）
        long hugeValue = 9_223_372_036_854_775_807L;
        int converted = (int) hugeValue; // 高位被截断
        System.out.println("转换后: " + converted); // 输出：-1
    }
}
