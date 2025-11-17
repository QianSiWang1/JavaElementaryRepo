package com.qy._03_lambda_stream._03_stream_basic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author QianSiWang
 * @Date 2022/8/7 10:50
 * @Description
 */
public class StreamCollectTest {
    public static void main(String[] args) {
        Person p1 = new Person("zhangsan", 26);
        Person p2 = new Person("lisi", 22);
        Person p3 = new Person("wangwu", 22);
        List<Person> list = Arrays.asList(p1, p2, p3);
        //装成list
        List<Integer> ageList = list.stream().map(Person::getAge).collect(Collectors.toList());//[26,22,22]
        System.out.println("转换成list的结果是：" + ageList);
        //转成set
        Set<Integer> ageSet = list.stream().map(Person::getAge).collect(Collectors.toSet());//[26,22]
        System.out.println("转换成set的结果是：" + ageSet);

        //转成map,注:key不能相同，否则报错
        Map<String, Integer> studentMap = list.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
        // {zhangsan=26, lisi=22, wangwu=22}
        System.out.println("转换成map的结果是：" + studentMap);

        //字符串分隔符连接
        String joinName = list.stream().map(Person::getName).collect(Collectors.joining(",", "(", ")"));
        // (zhangsan,lisi,wangwu)
        System.out.println("字符串分隔连接的结果是：" + joinName);

        //聚合操作
        //1.总数
        Long count = list.stream().collect(Collectors.counting()); // 3
        System.out.println("总数是："+count);
        //2.最大年龄 (最小的minBy同理)
        Integer maxAge = list.stream().map(Person::getAge).collect(Collectors.maxBy(Integer::compare)).get(); // 26
        System.out.println("最大年龄：" + maxAge);
        //3.所有人的年龄求和
        Integer sumAge = list.stream().collect(Collectors.summingInt(Person::getAge)); // 70
        System.out.println("年龄求和是：" + sumAge);
        //4.平均年龄
        Double averageAge = list.stream().collect(Collectors.averagingDouble(Person::getAge)); // 23.333333333333332
        System.out.println("平均年龄是："+averageAge);
        // 带上以上所有方法
        DoubleSummaryStatistics statistics = list.stream().collect(Collectors.summarizingDouble(Person::getAge));
        System.out.println("count:" + statistics.getCount() + ",max:" + statistics.getMax() + ",sum:" + statistics.getSum() + ",average:" + statistics.getAverage());

        //分组 按年龄分组
        Map<Integer, List<Person>> ageMap = list.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println("按年龄分组的结果是："+ageMap);
        //分区
        //分成两部分，一部分大于10岁，一部分小于等于10岁
        Map<Boolean, List<Person>> partMap = list.stream().collect(Collectors.partitioningBy(v -> v.getAge() > 10));
        System.out.println("分区的结果是："+partMap);
        //规约
        Integer allAge = list.stream().map(Person::getAge).collect(Collectors.reducing(Integer::sum)).get(); //40　

    }
}
