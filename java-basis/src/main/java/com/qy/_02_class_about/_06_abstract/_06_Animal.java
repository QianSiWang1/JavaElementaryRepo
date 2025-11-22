package com.qy._02_class_about._06_abstract;

// 抽象类
public abstract class _06_Animal {
    // 成员变量
    protected String name;
    protected int age;

    // 构造方法
    public _06_Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 抽象方法 - 没有方法体
    public abstract void makeSound();

    // 具体方法 - 有方法体
    public void sleep() {
        System.out.println(name + "正在睡觉...");
    }

    // 具体方法
    public void eat() {
        System.out.println(name + "正在吃东西...");
    }

    // 具体方法
    public String getName() {
        return name;
    }
}
