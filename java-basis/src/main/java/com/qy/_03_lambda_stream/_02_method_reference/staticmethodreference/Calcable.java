package com.qy._03_lambda_stream._02_method_reference.staticmethodreference;

@FunctionalInterface
public interface Calcable {
    //定义一个抽象方法,传递一个整数,对整数进行绝对值计算并返回
    int calsAbs(int number);
}
