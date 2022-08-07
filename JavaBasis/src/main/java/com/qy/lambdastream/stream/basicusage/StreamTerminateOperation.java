package com.qy.lambdastream.stream.basicusage;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author QianSiWang
 * @Date 2022/8/7 10:23
 * @Description 流的终止操作
 */
public class StreamTerminateOperation {

    /**
     * 一些简单终止操作的演示
     */
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        boolean allMatch = list.stream().allMatch(e -> e > 10); //false
        boolean noneMatch = list.stream().noneMatch(e -> e > 10); //true
        boolean anyMatch = list.stream().anyMatch(e -> e > 4); //true

        Optional<Integer> first = list.stream().findFirst();//返回的是一个Optional
        Integer findFirst = (Integer) first.get();//.get(); //1
        Integer findAny = list.stream().findAny().get(); //1

        long count = list.stream().count(); //5
        Integer max = list.stream().max(Integer::compareTo).get(); //5
        Integer min = list.stream().min(Integer::compareTo).get(); //1　

    }

    /**
     * reduce的几个重载方法测试
     */
    @Test
    public void test2(){
        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6);
        Integer sum = s.reduce((a, b) -> a + b).get();
        System.out.println(sum);//21

        Stream<String> strStream = Stream.of("Java", "8", "In", "Action");
        System.out.println(strStream.reduce("[Qy]", (s1, s2) -> s1.concat(s2)));//

        System.out.println("==========================");
        Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");
        System.out.println(s1.reduce(new ArrayList<String>(), (r, t) -> {r.add(t); return r; }, (r1, r2) -> r1));
        System.out.println("===========================");

    }

}
