package com.qy._99_design_pattern.behavioral.template;

// 客户端代码
public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        // 制作咖啡
        BeverageMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.makeBeverage();

        System.out.println("---------------------");

        // 制作茶
        BeverageMaker teaMaker = new TeaMaker();
        teaMaker.makeBeverage();
    }
}
