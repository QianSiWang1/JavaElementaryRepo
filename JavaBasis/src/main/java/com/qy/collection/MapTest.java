package com.qy.collection;

import org.junit.Test;

import java.util.*;

/**
 * @Author QianSiWang
 * @Date 2022/8/15 21:28
 * @Description
 */
public class MapTest {
    @Test
    public void mapTest1() {
        Hashtable<Integer, Integer> hashtable = new Hashtable();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
    }

    @Test
    public void mapTest2() {
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

    }

    @Test
    public void mapTest3() {
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
    }

    /**
     * Map的遍历方式
     */
    @Test
    public void mapTest4() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "v1");
        map.put(2, "v2");
        map.put(3, "v3");

        //使用map.keySet 增强for遍历
        System.out.println("使用map.keySet 增强for遍历");
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            System.out.println("键是:" + integer + ",值是:" + map.get(integer));
        }
        //使用map.keySet 迭代器遍历
        System.out.println("使用map.keySet 迭代器遍历");
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println("键是:" + next + ",值是:" + map.get(next));
        }
        //使用map.entrySet 增强for遍历
        System.out.println("使用map.entrySet 增强for遍历");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println("键是:" + entry.getKey() + ",值是:" + entry.getValue());
        }

        //使用map.entrySet 迭代器遍历
        System.out.println("使用map.entrySet 迭代器遍历");
        Iterator<Map.Entry<Integer, String>> iterator1 = map.entrySet().iterator();
        while(iterator1.hasNext()){
            Map.Entry<Integer, String> next = iterator1.next();
            System.out.println("键是:" + next.getKey() + ",值是:" + next.getValue());
        }
        //使用lambda表达式 foreach遍历
        map.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));
    }
}
