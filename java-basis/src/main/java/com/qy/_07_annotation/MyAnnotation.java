package com.qy._07_annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author QianSiWang
 * @Date 2022/8/17 18:14
 * @Description
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name() default "QianYu";
    int age() default 24;
}
