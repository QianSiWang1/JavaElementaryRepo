package com.qy.fastjson;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        //teacher.setType("teacher");
        teacher.setName("qianyu");
        teacher.setSalary(5000);
        teacher.setType("teacher");
        Teacher teacher2 = new Teacher();
        //teacher.setType("teacher");
        teacher2.setName("qianyu222");
        teacher2.setSalary(123);
        teacher2.setType("teacher22");
        String jsonString = JSON.toJSONString(teacher, SerializerFeature.WriteClassName);
        System.out.println(jsonString);
        People people = JSON.parseObject(jsonString, People.class);
        List<People> list = new ArrayList<>();
        list.add(teacher);
        list.add(teacher2);
        String jsonString1 = JSON.toJSONString(list,SerializerFeature.WriteClassName);
        List<People> peopleList = JSON.parseArray(jsonString1,People.class);
    }
}
