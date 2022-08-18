package com.qy.annotation;

/**
 * @Author QianSiWang
 * @Date 2022/8/17 18:14
 * @Description
 */
public @interface MyAnnotation {
    String name() default "QianYu";
    int age() default 24;
}
