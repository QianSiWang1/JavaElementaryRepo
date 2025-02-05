package com.qy.designpattern.behavioral.interpreter;

import java.util.Map;

// 抽象表达式
interface Expression {
    int interpret(Map<String, Integer> context);
}

