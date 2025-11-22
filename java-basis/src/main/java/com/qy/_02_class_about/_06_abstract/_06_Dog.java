package com.qy._02_class_about._06_abstract;

// 具体子类
public class _06_Dog extends _06_Animal {
    private String breed;

    public _06_Dog(String name, int age, String breed) {
        super(name, age);  // 调用父类构造方法
        this.breed = breed;
    }

    // 实现抽象方法
    @Override
    public void makeSound() {
        System.out.println(name + "汪汪叫！");
    }

    // 子类特有的方法
    public void fetch() {
        System.out.println(name + "正在接飞盘！");
    }
}
