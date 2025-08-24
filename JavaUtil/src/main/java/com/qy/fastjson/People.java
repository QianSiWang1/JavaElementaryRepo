package com.qy.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;

@Data
@JSONType(typeName = "people", seeAlso = {Student.class, Teacher.class})
public class People {
    private String name;

    private String type;
}
