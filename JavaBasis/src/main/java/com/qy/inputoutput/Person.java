package com.qy.inputoutput;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author QianSiWang
 * @Date 2022/8/19 23:24
 * @Description
 */
@Data
@AllArgsConstructor
public class Person implements Serializable {
    String name;
    int age;
}
