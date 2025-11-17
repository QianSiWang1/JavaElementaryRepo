package com.qy._99_design_pattern.structure.decorator;

// 具体装饰者：牛奶
class Milk extends CondimentDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.5;
    }
}
