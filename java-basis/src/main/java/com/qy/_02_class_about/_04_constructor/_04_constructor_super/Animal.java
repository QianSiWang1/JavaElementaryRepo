package com.qy._02_class_about._04_constructor._04_constructor_super;

public class Animal {
    private String name;
    private int age;

    public Animal() {
        System.out.println("Animal 无参构造器");
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animal 有参构造器: " + name);
    }
}
