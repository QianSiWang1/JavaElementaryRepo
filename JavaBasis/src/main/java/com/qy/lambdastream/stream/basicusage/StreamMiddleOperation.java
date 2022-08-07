package com.qy.lambdastream.stream.basicusage;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author QianSiWang
 * @Date 2022/8/6 22:29
 * @Description 流的中间操作
 */
public class StreamMiddleOperation {

    @Test
    public void test1() {
        Stream<Integer> stream = Stream.of(6, 6, 6, 12, 22, 12, 213, 111, 7, 9, 10);
        Stream<Integer> streamFilter = stream.filter(item -> item > 10) // 12 22 12 213 111
                .distinct() //12 22 213 111
                .skip(2) //213 111
                .limit(1);//213
        streamFilter.forEach(System.out::println);
    }

    @Test
    public void test2() {

        List<String> list = Arrays.asList("String", "f,g,h");
        Stream<String> stringStream = list.stream().map(s -> s.replaceAll(",", ""));//String fgh
        stringStream.forEach(System.out::println);
        System.out.println("===========================================");
        //flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<String> stringStream2 = list.stream().flatMap(s -> {
            String[] split = s.split(",");
            Stream<String> testStream = Arrays.stream(split);
            return testStream;
        });//String f g h
        stringStream2.forEach(System.out::println);

    }
}
