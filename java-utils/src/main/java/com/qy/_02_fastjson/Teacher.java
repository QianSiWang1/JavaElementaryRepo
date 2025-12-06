package com.qy._02_fastjson;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;

@JSONType(typeName = "teacher")
@Data
public class Teacher extends People {
    private int salary;
}
