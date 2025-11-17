package com.qy._04_collection._02_list;

import org.junit.Test;

import java.util.*;

/**
 * @Author QianSiWang
 * @Date 2022/8/10 20:02
 * @Description
 */
public class ListTest {
    public static void main(String[] args) {

    }

    /**
     * ArrayList
     */
    @Test
    public void listTest1(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        System.out.println(arrayList);
    }

    /**
     * Vector
     */
    @Test
    public void listTest2(){
        Vector<Integer> vector = new Vector<>();
        vector.add(42);
    }

    /**
     *
     */
    @Test
    public void listTest3(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        /*
        Arrays.ArrayList是一个固定长度的List集合，程序只能遍历访问该集合里的元素，不可增加、删除该集合里的元素。
        java.lang.UnsupportedOperationException
         */
        //integers.add(1);

    }


}
