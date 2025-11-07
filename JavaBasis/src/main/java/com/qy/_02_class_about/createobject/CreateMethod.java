package com.qy._02_class_about.createobject;

import java.io.*;

public class CreateMethod {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Dog dog = new Dog();
        dog.shout("new");
        createObjectByClone();
        createObjectByDeserialize();
        createObjectByReflect();
    }

    //使用反射创建对象
    public static void createObjectByReflect() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("com.qy._02_class_about.createobject.Dog");
        Dog dog = (Dog) clazz.newInstance();
        dog.shout("反射");
    }

    //使用Clone方法创建对象
    public static void createObjectByClone() throws CloneNotSupportedException {
        Dog dog = new Dog();
        Dog dog1 = (Dog) dog.clone();
        dog1.shout("克隆");
    }

    //使用反序列化创建对象
    public static void createObjectByDeserialize() throws IOException, ClassNotFoundException {
        Dog dog = new Dog();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dog.txt"));
        oos.writeObject(dog);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dog.txt"));
        Dog dog1 = (Dog) ois.readObject();
        ois.close();
        dog1.shout("反序列化");
    }
}
