package com.qy.classabout.createobject;

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
