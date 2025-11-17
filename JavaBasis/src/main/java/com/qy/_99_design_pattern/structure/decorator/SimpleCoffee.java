package com.qy._99_design_pattern.structure.decorator;

// 具体组件：原味咖啡
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
