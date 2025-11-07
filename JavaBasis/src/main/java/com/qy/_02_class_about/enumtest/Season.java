package com.qy._02_class_about.enumtest;

/**
 * @Author QianSiWang
 * @Date 2022/7/31 13:08
 * @Description
 */
public enum Season {
    SPRING("春天", 1),
    SUMMER("夏天", 2),
    FALL("秋天", 3),
    WINTER("冬天", 4);

    private final String name;
    private final int quarter;

    Season(String name, int quarter) {
        this.name = name;
        this.quarter = quarter;
    }

    public int getQuarter() {
        return quarter;
    }
    public String getName() {
        return name;
    }
}
