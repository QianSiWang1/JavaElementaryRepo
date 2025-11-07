package com.qy._01_basic;

import java.util.Arrays;
import java.util.Comparator;

public class _17_Arrays {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 9, 3, 7, 4, 6};

        // 1. 排序
        System.out.println("原始数组: " + Arrays.toString(numbers));
        Arrays.sort(numbers); // 快速排序
        System.out.println("排序后: " + Arrays.toString(numbers));

        // 2. 二分查找（必须先排序）
        int index = Arrays.binarySearch(numbers, 7);
        System.out.println("元素7的索引: " + index);

        // 3. 填充数组
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 42);
        System.out.println("填充后: " + Arrays.toString(filledArray));

        // 4. 部分填充
        int[] partialFill = new int[10];
        Arrays.fill(partialFill, 2, 7, 99); // 索引2到6（不包括7）填充为99
        System.out.println("部分填充: " + Arrays.toString(partialFill));

        // 5. 数组比较
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 4};
        System.out.println("arr1 equals arr2: " + Arrays.equals(arr1, arr2));
        System.out.println("arr1 equals arr3: " + Arrays.equals(arr1, arr3));

        // 6. 数组复制
        int[] original = {1, 2, 3, 4, 5};
        int[] copy1 = Arrays.copyOf(original, 3); // 复制前3个元素
        int[] copy2 = Arrays.copyOf(original, 7); // 复制到7个元素，多出的为默认值
        int[] copy3 = Arrays.copyOfRange(original, 1, 4); // 复制索引1到3的元素

        System.out.println("copyOf(3): " + Arrays.toString(copy1));
        System.out.println("copyOf(7): " + Arrays.toString(copy2));
        System.out.println("copyOfRange(1,4): " + Arrays.toString(copy3));

        // 7. 转换为字符串
        String arrayString = Arrays.toString(numbers);
        System.out.println("数组字符串: " + arrayString);

        // 8. 多维数组的深度操作
        int[][] deepArray1 = {{1, 2}, {3, 4}};
        int[][] deepArray2 = {{1, 2}, {3, 4}};
        int[][] deepArray3 = {{1, 2}, {3, 5}};

        System.out.println("深度比较1和2: " + Arrays.deepEquals(deepArray1, deepArray2));
        System.out.println("深度比较1和3: " + Arrays.deepEquals(deepArray1, deepArray3));
        System.out.println("深度字符串: " + Arrays.deepToString(deepArray1));

        // 9. 并行排序（大数据量时性能更好）
        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int)(Math.random() * 10000);
        }
        Arrays.parallelSort(largeArray); // 并行排序
        System.out.println("前10个元素: " + Arrays.toString(Arrays.copyOf(largeArray, 10)));

        // 10. 使用自定义比较器（对对象数组）
        String[] names = {"Alice", "Bob", "Charlie", "David"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1); // 降序排序
            }
        });
        System.out.println("降序排序: " + Arrays.toString(names));

        // 11. 使用lambda表达式（Java 8+）
        Arrays.sort(names, (s1, s2) -> s1.compareTo(s2)); // 升序排序
        System.out.println("升序排序: " + Arrays.toString(names));
    }
}
