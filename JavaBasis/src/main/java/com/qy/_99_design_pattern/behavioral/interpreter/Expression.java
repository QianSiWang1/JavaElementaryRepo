package com.qy._99_design_pattern.behavioral.interpreter;

import java.util.Map;

// 抽象表达式
interface Expression {
    int interpret(Map<String, Integer> context);
}

