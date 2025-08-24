package com.qy.jackson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,      // 使用类型名称作为标识符
        property = "type"        ,     // 属性名为"type"
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Teacher.class, name = "teacher"),
        @JsonSubTypes.Type(value = Student.class, name = "student")
})
public class People {
    private String name;

    private String type;
}
