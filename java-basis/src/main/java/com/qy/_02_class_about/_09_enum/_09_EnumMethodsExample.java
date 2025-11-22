package com.qy._02_class_about._09_enum;

public class _09_EnumMethodsExample {
    public static void main(String[] args) {
        _09_Day day = _09_Day.MONDAY;

        // 1. name() - 返回枚举常量的名称
        System.out.println(day.name()); // "MONDAY"

        // 2. ordinal() - 返回枚举常量的序数（从0开始）
        System.out.println(day.ordinal()); // 0

        // 3. values() - 返回所有枚举值的数组
        _09_Day[] allDays = _09_Day.values();
        for (_09_Day d : allDays) {
            System.out.println(d);
        }

        // 4. valueOf() - 根据字符串返回枚举常量
        _09_Day monday = _09_Day.valueOf("MONDAY");
        //报错
        //_09_Day monday1 = _09_Day.valueOf("MONDAY");
        // 5. compareTo() - 比较两个枚举常量的顺序
        System.out.println(_09_Day.MONDAY.compareTo(_09_Day.TUESDAY)); // -1

        // 6. toString() - 默认返回name()，可以重写
        System.out.println(day.toString()); // "MONDAY"
    }
}
