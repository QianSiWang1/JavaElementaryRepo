package com.qy._02_class_about._02_method;

public class _02_Method_Varargs {
    public static void main(String[] args) {
        _02_Method_Varargs example = new _02_Method_Varargs();

        // 使用可变参数
        System.out.println("求和1: " + example.sum(1, 2, 3));           // 3个参数
        System.out.println("求和2: " + example.sum(1, 2, 3, 4, 5));    // 5个参数
        System.out.println("求和3: " + example.sum());                 // 0个参数

        // 混合参数
        example.printDetails("数值", 1, 2, 3, 4, 5);
        example.printDetails("空数值"); // 可变参数可以为空

        // 方法重载
        example.process("A", "B", "C");
        example.process(100, "X", "Y", "Z");

        // 传递数组给可变参数
        String[] array = {"Java", "Python", "C++"};
        example.showArray(array);        // 传递数组
        example.showArray("One", "Two"); // 直接传递参数

        // 注意：不能同时有多个可变参数
        // public void errorMethod(String... strs, int... nums) {} // 编译错误
    }
    // 1. 基本可变参数
    public int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    // 2. 可变参数与其他参数组合（可变参数必须在最后）
    public void printDetails(String message, int... values) {
        System.out.print(message + ": ");
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // 3. 重载与可变参数
    public void process(String... strings) {
        System.out.println("处理字符串数组，长度: " + strings.length);
    }

    public void process(int number, String... strings) {
        System.out.println("处理数字 " + number + " 和字符串数组，长度: " + strings.length);
    }

    // 4. 使用数组作为可变参数
    public void showArray(String... items) {
        System.out.println("数组内容: " + java.util.Arrays.toString(items));
    }
}
