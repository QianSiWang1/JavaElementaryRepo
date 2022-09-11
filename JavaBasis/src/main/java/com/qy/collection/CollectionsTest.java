package com.qy.collection;

import com.qy.classabout.method.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author QianSiWang
 * @Date 2022/8/15 21:38
 * @Description
 */
public class CollectionsTest {
    /**
     * 排序操作
     */
    @Test
    public void collectionsTest1(){
        //能直接sort是因为 Integer内部实现了Comparable<Integer>接口
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(3);
        list01.add(2);
        System.out.println(list01);//[1, 3, 2]

        //public static <T> void sort(List<T> list):将集合中元素按照默认规则排序。
        //默认是升序[1, 2, 3]
        Collections.sort(list01);
        System.out.println(list01);
        //使用comparator参数 自定义排序 [3, 2, 1]
        Collections.sort(list01,(o1, o2) -> o2-o1);

        System.out.println(list01);//

        ArrayList<String> list02 = new ArrayList<>();
        list02.add("a");
        list02.add("c");
        list02.add("b");
        System.out.println(list02);//[a, c, b]

        Collections.sort(list02);
        System.out.println(list02);//[a, b, c]

        ArrayList<Person> list03 = new ArrayList<>();
        list03.add(new Person("张三",18));
        list03.add(new Person("李四",20));
        list03.add(new Person("王五",15));
        System.out.println(list03);//[Person{name='张三', age=18}, Person{name='李四', age=20}, Person{name='王五', age=15}]

        Collections.sort(list03);
        System.out.println(list03);
    }

    /**
     * 查找替换操作
     */
    @Test
    public void collectionsTest2(){
        List<Integer> list = Arrays.asList(1,5,2,1,6,7,8,1,16,17,21,4);
        //查找索引
        int i = Collections.binarySearch(list, 8);
        System.out.println(i);

        List<String> list1 = new ArrayList<>(16);
        list1.add("123");
        list1.add("234");
        //fill填充不如理解为替换
        Collections.fill(list1,"abc");
        System.out.println(list1);
    }

    /**
     * java9 创建不可变集合
     */
    @Test
    public void collectionsTest3(){
        //List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);//其他类型集合一样
        //list.forEach(System.out::println);
        //list.add(9);//会报错
    }
}
