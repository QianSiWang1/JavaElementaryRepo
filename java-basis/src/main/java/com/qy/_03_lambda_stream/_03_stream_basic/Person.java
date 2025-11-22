package com.qy._03_lambda_stream._03_stream_basic;

/**
 * @Author QianSiWang
 * @Date 2022/8/7 10:49
 * @Description stream测试用到的Person类
 */

public class Person {
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
