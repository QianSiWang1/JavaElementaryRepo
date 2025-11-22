package com.qy._99_design_pattern.create.builder;

// 客户端代码
public class BuilderPatternDemo {
    public static void main(String[] args) {
        // 创建高端电脑建造者
        ComputerBuilder highEndBuilder = new HighEndComputerBuilder();
        ComputerDirector highEndDirector = new ComputerDirector(highEndBuilder);
        Computer highEndComputer = highEndDirector.constructComputer();
        System.out.println("High-End Computer: " + highEndComputer);

        // 创建低端电脑建造者
        ComputerBuilder lowEndBuilder = new LowEndComputerBuilder();
        ComputerDirector lowEndDirector = new ComputerDirector(lowEndBuilder);
        Computer lowEndComputer = lowEndDirector.constructComputer();
        System.out.println("Low-End Computer: " + lowEndComputer);
    }
}
