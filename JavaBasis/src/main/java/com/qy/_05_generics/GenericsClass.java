package com.qy._05_generics;

/**
 * @Author QianSiWang
 * @Date 2022/8/15 22:07
 * @Description 自建的泛型类，泛型内的字母自定
 */
public class GenericsClass<XL> {
    private XL name;

    public XL getName() {
        return name;
    }

    public void setName(XL name) {
        this.name = name;
    }
}
