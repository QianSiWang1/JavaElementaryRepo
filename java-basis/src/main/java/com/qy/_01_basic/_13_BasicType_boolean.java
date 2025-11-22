package com.qy._01_basic;

public class _13_BasicType_boolean {
    public static void main(String[] args) {
        boolean defaultValue = false; // 默认值
        boolean isActive = true;
        boolean isCompleted = false;

        // 逻辑运算
        boolean result1 = true && false; // AND运算：false
        boolean result2 = true || false; // OR运算：true
        boolean result3 = !true;         // NOT运算：false

        System.out.println("true AND false = " + result1);
        System.out.println("true OR false = " + result2);
        System.out.println("NOT true = " + result3);

        // 比较运算
        int a = 10, b = 20;
        boolean isEqual = (a == b);        // false
        boolean isGreater = (a > b);       // false
        boolean isLessOrEqual = (a <= b);  // true

        System.out.println("a == b: " + isEqual);
        System.out.println("a > b: " + isGreater);
        System.out.println("a <= b: " + isLessOrEqual);

        // 条件语句中的应用
        boolean hasPermission = true;
        boolean isValid = false;

        if (hasPermission && isValid) {
            System.out.println("操作允许");
        } else {
            System.out.println("操作不允许");
        }

        // 三元运算符
        int score = 85;
        boolean isPass = (score >= 60) ? true : false;
        System.out.println("考试通过: " + isPass);

        // 布尔值与字符串转换
        String boolStr = "true";
        boolean fromString = Boolean.parseBoolean(boolStr);
        System.out.println("从字符串转换: " + fromString);

        // 注意：Java中boolean不能与整数类型转换
        // int num = isActive; // 编译错误！
        // boolean flag = 1;   // 编译错误！
    }
}
