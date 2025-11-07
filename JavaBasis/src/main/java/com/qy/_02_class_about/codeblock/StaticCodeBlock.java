package com.qy._02_class_about.codeblock;

/**
 * @Author QianSiWang
 * @Date 2022/7/27 22:26
 * @Description 静态代码块
 * 静态块用于初始化类，为类的属性初始化。
 *
 * 每个静态代码块只会执行一次。由于JVM在加载类时会执行静态代码块，所以静态代码块先于主方法执行。
 */
public class StaticCodeBlock {
    public static void main(String[] args) {
        StaticCodeBlock staticCodeBlock = new StaticCodeBlock();
        System.out.println(staticCodeBlock.getAge());
    }
    private static int age;

    private String name;

    private String sex;

    static {
        age = 25;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
