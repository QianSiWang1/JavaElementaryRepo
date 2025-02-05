package com.qy.designpattern.behavioral.template;

// 抽象类：饮料制作模板
abstract class BeverageMaker {
    // 模板方法，定义了制作饮料的算法骨架
    public final void makeBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // 固定步骤：烧水
    private void boilWater() {
        System.out.println("Boiling water");
    }

    // 可变步骤：冲泡，由子类实现
    protected abstract void brew();

    // 固定步骤：倒入杯子
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // 可变步骤：添加调料，由子类实现
    protected abstract void addCondiments();
}

