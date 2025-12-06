package com.qy._02_fastjson;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;

@Data
@JSONType(typeName = "student")
public class Student extends People {
    private String grade;
}
