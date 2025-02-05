package com.qy.designpattern.create.builder;

// 抽象建造者
interface ComputerBuilder {
    void buildCpu();

    void buildMemory();

    void buildHardDisk();

    Computer getComputer();
}
