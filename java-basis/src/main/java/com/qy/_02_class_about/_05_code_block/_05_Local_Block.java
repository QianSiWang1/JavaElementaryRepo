package com.qy._02_class_about._05_code_block;

public class _05_Local_Block {
    public void demoMethod() {
        // 方法开始
        int outerVar = 100;
        System.out.println("外部变量: " + outerVar);

        { // 局部代码块开始
            int innerVar = 200;
            System.out.println("内部变量: " + innerVar);
            System.out.println("可以访问外部变量: " + outerVar);
        } // 局部代码块结束

        // System.out.println(innerVar); // 编译错误：innerVar 不在作用域内
        System.out.println("外部变量仍然可用: " + outerVar);
    }
}
