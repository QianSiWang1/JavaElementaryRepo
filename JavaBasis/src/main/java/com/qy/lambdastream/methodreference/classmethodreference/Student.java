package com.qy.lambdastream.methodreference.classmethodreference;

/**
 * @Author QianSiWang
 * @Date 2022/7/31 17:25
 * @Description
 */
public class Student {
    private String name;
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    //静态方法（类方法）
    public static int compareStudentByScore(Student student1, Student student2) {
        return (int) student1.getScore() - (int) student2.getScore();
    }

    //实例方法（对象方法）
    public int compareStudentByName(Student student) {
        return this.getName().compareToIgnoreCase(student.getName());
    }
}


