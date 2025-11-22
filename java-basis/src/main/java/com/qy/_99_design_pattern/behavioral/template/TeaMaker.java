package com.qy._99_design_pattern.behavioral.template;

// 具体子类：茶制作
class TeaMaker extends BeverageMaker {
    @Override
    protected void brew() {
        System.out.println("Steeping tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}
