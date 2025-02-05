package com.qy.designpattern.structure.decorator;

// 客户端代码
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // 创建一杯原味咖啡
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " costs $" + coffee.cost());

        // 为咖啡添加牛奶
        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + " costs $" + coffee.cost());

        // 再为咖啡添加糖
        coffee = new Sugar(coffee);
        System.out.println(coffee.getDescription() + " costs $" + coffee.cost());
    }
}
