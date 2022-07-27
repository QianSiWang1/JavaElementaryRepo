package com.qy.objectoriented.codeblock;

/**
 * @Author QianSiWang
 * @Date 2022/7/27 22:18
 * @Description 构造代码块
 * 构造代码块在创建对象时被调用，每次创建对象都会被调用，
 * 并且构造代码块的执行次序优先于类构造函数。
 * 如果存在多个构造代码块，执行顺序由他们在代码中出现的次序决定，先出现先执行。
 */
public class ConstructorCodeBlock {

    public static void main(String[] args) {
        new ConstructorCodeBlock(1);
        new ConstructorCodeBlock(2);
    }
    {
        System.out.println("构造代码块 1");
    }

    ConstructorCodeBlock(int i){
        System.out.println(i);
    }

    {
        System.out.println("构造代码快 2");
    }
}
