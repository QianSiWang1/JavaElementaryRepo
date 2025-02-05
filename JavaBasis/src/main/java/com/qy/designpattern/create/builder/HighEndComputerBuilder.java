package com.qy.designpattern.create.builder;

// 具体建造者：高端电脑建造者
class HighEndComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public HighEndComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCpu() {
        computer.setCpu("Intel Core i9");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("32GB DDR4");
    }

    @Override
    public void buildHardDisk() {
        computer.setHardDisk("1TB SSD");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
