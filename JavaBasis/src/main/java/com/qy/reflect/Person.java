package com.qy.reflect;

import lombok.Data;

/**
 * @Author QianSiWang
 * @Date 2022/8/21 15:37
 * @Description 反射用例对象
 */
@Data
public class Person {
    public String name;
    public int age;
    private int num;

    public void func(){
        System.out.println("无参方法");
    }

    public void func(String str){
        System.out.println("有参方法" + str);
    }

    private  void privateFunc(){
        System.out.println("私有方法");
    }
}
