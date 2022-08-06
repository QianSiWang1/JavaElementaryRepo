package com.qy.lambdastream.stream.basicusage;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @Author QianSiWang
 * @Date 2022/8/6 11:02
 * @Description 流的几种创建方式
 */
public class CreateStream {

    public static void main(String[] args) {

    }


    /**
     * 使用collection下的
     * stream方法
     * parallelStream方法
     */
    @Test
    public void createTest1() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> stream = arr.stream();
        stream.forEach(System.out::println);
        //流只能使用一次
        //stream.forEach(System.out::println);
        Stream<Integer> integerStream = arr.parallelStream();
        integerStream.forEach(System.out::println);//多线程，打印顺序明显变化


    }

    /**
     * Arrays中的stream方法，将数组转换为流
     */
    @Test
    public void createTest2() {
        String[] strs = new String[]{"2022", "08", "03", "钱誉","❤","韩雨辰"};
        Stream<String> stream = Arrays.stream(strs);
        stream.forEach(System.out::println);
    }

    /**
     * 使用stream中的静态方法
     */
    @Test
    public void createTest3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream.forEach(System.out::println);
        System.out.println("===================================================");
        //iterate创建无限流，使用limit来限制数量
        Stream<String> limit = Stream.iterate("x", x -> x + "x").limit(5);
        limit.forEach(System.out::println);

        System.out.println("=============================================");
        Stream<Integer> generate = Stream.generate(() -> new Random().nextInt(10)).limit(5);
        generate.forEach(System.out::println);
    }
}
