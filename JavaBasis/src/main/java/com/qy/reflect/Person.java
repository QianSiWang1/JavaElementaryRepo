package com.qy.reflect;

import com.qy.annotation.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author QianSiWang
 * @Date 2022/8/21 15:37
 * @Description 反射用例对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MyAnnotation(age = 40,name = "zhangsan")
public class Person {
    public String name;
    public int age;
    private int num;

    public void func(){
        System.out.println("无参方法");
    }

    public void funcStr(String str){
        System.out.println("有参方法" + str);
    }

    private  void privateFunc(){
        System.out.println("私有方法");
    }
}
