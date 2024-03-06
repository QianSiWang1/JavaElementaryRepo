package com.qy.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
