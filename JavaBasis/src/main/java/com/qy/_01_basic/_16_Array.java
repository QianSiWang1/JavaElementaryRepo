package com.qy._01_basic;

public class _16_Array {
    public static void main(String[] args) {
        // 1. 声明数组
        int[] numbers; // 推荐写法
        //int numbers2[]; // C风格写法，不推荐

        // 2. 初始化数组
        // 方式1：声明时直接初始化
        int[] arr1 = {1, 2, 3, 4, 5};

        // 方式2：先声明，后初始化
        int[] arr2;
        arr2 = new int[]{1, 2, 3, 4, 5};

        // 方式3：指定大小，元素为默认值
        int[] arr3 = new int[5]; // 所有元素初始化为0

        // 3. 默认值
        int[] intArr = new int[3];        // 所有元素为 0
        double[] doubleArr = new double[3]; // 所有元素为 0.0
        boolean[] boolArr = new boolean[3]; // 所有元素为 false
        String[] strArr = new String[3];   // 所有元素为 null
        char[] charArr = new char[3];      // 所有元素为 '\u0000'（空字符）

        System.out.println("int默认值: " + intArr[0]);
        System.out.println("double默认值: " + doubleArr[0]);
        System.out.println("boolean默认值: " + boolArr[0]);
        System.out.println("String默认值: " + strArr[0]);
        System.out.println("char默认值: " + (int)charArr[0]); // 输出Unicode值
    /*
    =========================================================================================================
     */
        // 创建数组
        int[] numbers2 = {10, 20, 30, 40, 50};

        // 1. 访问元素
        System.out.println("第一个元素: " + numbers2[0]); // 10
        System.out.println("最后一个元素: " + numbers2[numbers2.length - 1]); // 50

        // 2. 修改元素
        numbers2[2] = 300; // 将第三个元素从30改为300
        System.out.println("修改后第三个元素: " + numbers2[2]); // 300

        // 3. 数组长度
        System.out.println("数组长度: " + numbers2.length); // 5

        // 4. 遍历数组
        System.out.println("数组元素:");
        for (int i = 0; i < numbers2.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers2[i]);
        }

        // 5. 使用增强for循环（foreach）
        System.out.println("使用foreach遍历:");
        for (int number : numbers2) {
            System.out.println(number);
        }

        // 6. 边界检查
        try {
            System.out.println(numbers2[10]); // 数组越界
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组索引越界: " + e.getMessage());
        }

        // 7. 空数组检查
        int[] emptyArray = null;
        if (emptyArray != null && emptyArray.length > 0) {
            System.out.println(emptyArray[0]);
        } else {
            System.out.println("数组为空或为null");
        }
    }

}
