package com.qy._99_design_pattern.structure.decorator;

// 抽象装饰者：调料
abstract class CondimentDecorator implements Coffee {
    protected Coffee coffee;

    public CondimentDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double cost() {
        return coffee.cost();
    }
}
