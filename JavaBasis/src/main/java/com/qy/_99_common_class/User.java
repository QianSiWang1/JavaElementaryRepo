package com.qy._99_common_class;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author QianSiWang
 * @Date 2022/8/30 23:31
 * @Description
 */
@Data
@AllArgsConstructor
public class User implements Cloneable{
    private String name;

    private int age;

    private User son;

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User)super.clone();
    }
}
