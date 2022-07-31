package com.qy.objectoriented.innerclass;

/**
 * @Author QianSiWang
 * @Date 2022/7/31 12:16
 * @Description
 */
public class InterClassTest {
    public static void main(String[] args) {
        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.staticInnerFunc();
    }
}
