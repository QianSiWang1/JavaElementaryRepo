package com.qy._04_collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author QianSiWang
 * @Date 2022/9/12 10:09
 * @Description
 */
public class ArrayTest {
    public static void main(String[] args) {

    }

    @Test
    public void test1(){
        Integer[] arr = {1,3,2,4,5,8,9,7,6};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
    }

    @Test
    public void test2(){
        Integer[] arr = {1,2,3,4,5,6,7};
        //找不到返回的是负数
        int i = Arrays.binarySearch(arr, 8);
        System.out.println(i);
        //如果找不到返回 -(fromIndex+1)
        int i1 = Arrays.binarySearch(arr, 1, 4, 5);
        System.out.println(i1);
    }

    @Test
    public void test3(){
        int[] arr = {1,2,3,4,5,6,7};
        int[] integers = Arrays.copyOf(arr, 4);
        System.out.println(Arrays.toString(integers));
        //超出的用0填充，非基本类型为null
        int[] integers2 = Arrays.copyOf(arr, 8);
        System.out.println(Arrays.toString(integers2));
        //左闭右开
        int[] ints = Arrays.copyOfRange(arr, 1, 4);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test4(){
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {1,2,3,4,5,6,7};
        int[] arr3 = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.equals(arr1,arr2));
        System.out.println(Arrays.equals(arr1,arr3));

    }


}
