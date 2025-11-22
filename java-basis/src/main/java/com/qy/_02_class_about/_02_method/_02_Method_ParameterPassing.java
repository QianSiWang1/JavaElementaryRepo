package com.qy._02_class_about._02_method;

public class _02_Method_ParameterPassing {
    public static void main(String[] args) {
        _02_Method_ParameterPassing example = new _02_Method_ParameterPassing();

        // 测试基本数据类型参数
        int number = 10;
        System.out.println("调用前: " + number);
        example.modifyPrimitive(number);
        System.out.println("调用后: " + number); // 仍然是10，不变
        System.out.println();

        // 测试数组参数
        int[] numbers = {1, 2, 3};
        System.out.println("调用前数组: " + java.util.Arrays.toString(numbers));
        example.modifyArray(numbers);
        System.out.println("调用后数组: " + java.util.Arrays.toString(numbers)); // 第一个元素被修改
        System.out.println();

        // 测试对象参数
        StringBuilder text = new StringBuilder("原始内容");
        System.out.println("调用前对象: " + text.toString());
        example.modifyObject(text);
        System.out.println("调用后对象: " + text.toString()); // 内容被修改
        System.out.println();

        // 测试重新赋值引用
        StringBuilder text2 = new StringBuilder("另一个内容");
        System.out.println("调用前对象: " + text2.toString());
        example.reassignReference(text2);
        System.out.println("调用后对象: " + text2.toString()); // 仍然是原始内容
    }
    // 1. 基本数据类型参数 - 值传递
    public void modifyPrimitive(int x) {
        x = x * 2;
        System.out.println("方法内修改后: " + x);
    }

    // 2. 引用数据类型参数 - 引用传递（传递引用的副本）
    public void modifyArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            arr[0] = 999;
            System.out.println("方法内修改数组后第一个元素: " + arr[0]);
        }
    }

    // 3. 对象参数
    public void modifyObject(StringBuilder sb) {
        sb.append(" - 已修改");
        System.out.println("方法内修改对象: " + sb.toString());
    }

    // 4. 重新赋值引用（不影响原始引用）
    public void reassignReference(StringBuilder sb) {
        sb = new StringBuilder("新的内容");
        System.out.println("方法内重新赋值: " + sb.toString());
    }
}
