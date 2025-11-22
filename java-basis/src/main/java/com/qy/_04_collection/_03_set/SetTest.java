package com.qy._04_collection._03_set;


import com.qy._02_class_about._09_enum._09_Day;
import org.junit.Test;

import java.util.*;

/**
 * @Author QianSiWang
 * @Date 2022/8/7 16:13
 * @Description Demo set
 */
public class SetTest {
    /**
     * HashSet
     */
    @Test
    public void setTest1(){
        Set<String> hashSet = new HashSet<>(Arrays.asList("qy","Love","hyc","2022","forever"));
        System.out.println(hashSet);//无序

    }

    /**
     * LinkedHashSet
     */
    @Test
    public void setTest2(){
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList("qy","Love","hyc","2022","forever"));
        System.out.println(linkedHashSet);//有序打印
    }

    /**
     * TreeSet
     */
    @Test
    public void setTest3(){
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(2,5,4,1,7,6,9,0,8));
        Integer first = treeSet.first();
        System.out.println(first);
        Integer lower = treeSet.lower(4);
        System.out.println(lower);
        SortedSet<Integer> integers = treeSet.subSet(3, 7);
        System.out.println(integers);

    }

    /**
     * EnumSet类
     */
    @Test
    public void setTest4(){
        //集合元素是Season中的所有枚举类
        EnumSet<_09_Day> enumSet = EnumSet.allOf(_09_Day.class);
        enumSet.forEach(System.out::println);
        //创建一个空集合
        EnumSet<_09_Day> enumSet1 = EnumSet.noneOf(_09_Day.class);
        enumSet1.add(_09_Day.FRIDAY);
        enumSet1.add(_09_Day.MONDAY);
        enumSet1.forEach(System.out::println);
    }

}
