package com.qy.collection;

import com.qy.classabout.enumtest.Season;
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
        EnumSet<Season> enumSet = EnumSet.allOf(Season.class);
        enumSet.forEach(System.out::println);
        //创建一个空集合
        EnumSet<Season> enumSet1 = EnumSet.noneOf(Season.class);
        enumSet1.add(Season.SPRING);
        enumSet1.add(Season.SUMMER);
        enumSet1.forEach(System.out::println);
        //
    }

}
