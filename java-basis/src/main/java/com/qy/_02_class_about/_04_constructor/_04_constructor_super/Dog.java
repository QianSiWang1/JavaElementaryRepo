package com.qy._02_class_about._04_constructor._04_constructor_super;


public class Dog extends Animal {
    private String breed;

    public Dog() {
        super();  // 隐式调用，可以省略
        System.out.println("Dog 无参构造器");
    }

    public Dog(String name, int age, String breed) {
        super(name, age);  // 显式调用父类构造器，必须是第一行
        this.breed = breed;
        System.out.println("Dog 有参构造器: " + breed);
    }
}
