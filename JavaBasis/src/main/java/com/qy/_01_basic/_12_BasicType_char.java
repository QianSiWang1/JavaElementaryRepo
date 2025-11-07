package com.qy._01_basic;

public class _12_BasicType_char {
    public static void main(String[] args) {
        char minValue = Character.MIN_VALUE; // '\u0000'
        char maxValue = Character.MAX_VALUE; // '\uffff'
        char defaultValue = '\u0000'; // 默认值（空字符）

        // 多种表示方式
        char letterA = 'A';           // 字符字面量
        char unicodeA = '\u0041';     // Unicode 转义
        char digit = '7';             // 数字字符
        char newline = '\n';          // 转义字符
        char tab = '\t';              // 制表符

        System.out.println("字符A: " + letterA);
        System.out.println("Unicode A: " + unicodeA);
        System.out.println("数字字符: " + digit);

        // 字符运算（基于Unicode值）
        char first = 'A';
        char second = 'B';
        int difference = second - first;
        System.out.println("B - A = " + difference); // 输出：1

        // 转换为大写/小写
        char lower = 'a';
        char upper = Character.toUpperCase(lower);
        System.out.println(lower + " 的大写是: " + upper);

        // 字符检测
        char ch = '5';
        System.out.println("是数字吗? " + Character.isDigit(ch));
        System.out.println("是字母吗? " + Character.isLetter(ch));
        System.out.println("是空格吗? " + Character.isWhitespace(ch));

        // 注意：char是无符号的
        char c = 65; // 等同于 'A'
        System.out.println("字符值: " + c); // 输出：A
    }
}
