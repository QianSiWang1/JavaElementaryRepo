package com.qy._02_class_about._10_create_object;

import java.io.Serializable;

public class Dog implements Cloneable, Serializable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public  void shout(String name){
        System.out.println(name + ": wangwang");
    }
}
