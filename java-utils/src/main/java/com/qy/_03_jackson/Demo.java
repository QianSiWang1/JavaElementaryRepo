package com.qy._03_jackson;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Teacher teacher = new Teacher();
        teacher.setType("teacher");
        teacher.setName("qianyu");
        teacher.setTeacher("xixi");
        List<People> peopleList = new ArrayList<>();
        peopleList.add(teacher);
        String s = mapper.writeValueAsString(teacher);
        System.out.println(s);
        People people = mapper.readValue(s,People.class);
        String jsonString = JSON.toJSONString(teacher);
        System.out.println(jsonString);
        People people1 = mapper.readValue(jsonString,People.class);

        String listString = mapper.writeValueAsString(peopleList);
        System.out.println(listString);
        List<People> readPeopleList = mapper.readValue(listString, new TypeReference<List<People>>() {
        });
//        System.out.println(readPeopleList);
//        JavaType type = mapper.getTypeFactory()
//                .constructCollectionType(List.class, People.class);
//        List<People> people = mapper.readValue(listString, type);
    }
}
