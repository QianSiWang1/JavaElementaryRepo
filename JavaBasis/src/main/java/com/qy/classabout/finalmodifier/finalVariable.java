package com.qy.classabout.finalmodifier;

/**
 * @Author QianSiWang
 * @Date 2022/7/28 19:36
 * @Description
 */
public class finalVariable {
    public static void main(String[] args) {
        finalVariable finalVariable = new finalVariable();
        finalVariable.func1();
    }
    // 必须初始化，不然会报错
    // 1.直接赋值
    public final int instance_age = 100;
    public static final int class_age = 100;


    // 2.在代码块中赋值
    public final int instance_sex;

    public static final int class_sex;
    {
        instance_sex = 1;
    }

    static {
        class_sex  = 2;
    }

    public void func1(){
        //局部变量 显示初始化
        final int a  = 10;
        System.out.println(a);
    }
}
