package com.qy._02_class_about._03_variables;

import java.util.Map;

public class _03_LocalVariables {
    public int add(int a, int b) {
        // 方法局部变量
        int result = a + b;  // result 是局部变量
        return result;
    }

    public void processData() {
        int count = 0;       // 局部变量
        String message = "Processing...";

        for (int i = 0; i < 10; i++) {  // i 是局部变量
            count += i;
        }

        System.out.println(message + " Count: " + count);
    }
/*
*=======================================================================================================================
*/
    // name 和 age 是参数变量（局部变量的一种）
    public void setInfo(String name, int age) {
        // 方法体
    }

    // config 是参数变量
    public void configure(Map<String, Object> config) {
        // 方法体
    }
    /*
     *=======================================================================================================================
     */
    public void demo() {
        int x = 10;  // 方法局部变量

        { // 代码块开始
            int y = 20;  // 代码块局部变量
            System.out.println("x = " + x + ", y = " + y);
        } // 代码块结束

        // System.out.println(y); // 编译错误：y 不在作用域内
    }
}
