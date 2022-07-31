package com.qy.classabout.enumtest;

/**
 * @Author QianSiWang
 * @Date 2022/7/31 13:11
 * @Description
 */
public class EnumTest {
    public static void main(String[] args) {
        //Arrays.stream(Season.values()).sequential().forEach(System.out::println);

        System.out.println(Season.SUMMER.getQuarter());
        System.out.println(Season.SPRING.ordinal());
        System.out.println(Season.FALL.ordinal());
    }
}
