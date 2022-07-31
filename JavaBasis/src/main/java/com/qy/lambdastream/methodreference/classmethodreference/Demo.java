package com.qy.lambdastream.methodreference.classmethodreference;

import java.util.Arrays;
import java.util.List;

/**
 * @Author QianSiWang
 * @Date 2022/7/31 17:26
 * @Description 类名::实例方法 这种形式的方法引用有点难理解
 */
public class Demo {

    public static void main(String[] args) {
        Student student1 = new Student("周明",75);
        Student student2 = new Student("赵凯",83);
        Student student3 = new Student("李强",97);
        Student student4 = new Student("孙国",62);

        List<Student> students = Arrays.asList(student1,student2,student3,student4);

        students.sort(Student::compareStudentByName); //类名::实例方法
        students.forEach(student -> System.out.println(student.getScore()+student.getName()));

        System.out.println("=====================这是分隔符=======================");

        students.sort(((o1, o2) -> (int)o2.getScore()- (int)o1.getScore()));
        students.forEach(student -> System.out.println(student.getScore()+student.getName()));

        System.out.println("=====================这是分隔符=======================");

        students.sort(Student::compareStudentByScore);//类名::类方法
    }
}

