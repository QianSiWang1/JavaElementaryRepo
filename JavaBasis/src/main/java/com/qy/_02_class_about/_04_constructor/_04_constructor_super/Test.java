package com.qy._02_class_about._04_constructor._04_constructor_super;

public class Test {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        // 输出:
        // Animal 无参构造器
        // Dog 无参构造器

        Dog dog2 = new Dog("Buddy", 3, "Golden Retriever");
        // 输出:
        // Animal 有参构造器: Buddy
        // Dog 有参构造器: Golden Retriever
    }
}
