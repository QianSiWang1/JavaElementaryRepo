package com.qy.designpattern.behavioral.template;

// 具体子类：咖啡制作
class CoffeeMaker extends BeverageMaker {
    @Override
    protected void brew() {
        System.out.println("Brewing coffee");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
