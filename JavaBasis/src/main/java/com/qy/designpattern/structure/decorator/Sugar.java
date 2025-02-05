package com.qy.designpattern.structure.decorator;

// 具体装饰者：糖
class Sugar extends CondimentDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.3;
    }
}
