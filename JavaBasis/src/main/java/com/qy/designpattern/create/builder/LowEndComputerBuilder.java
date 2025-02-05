package com.qy.designpattern.create.builder;

// 具体建造者：低端电脑建造者
class LowEndComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public LowEndComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCpu() {
        computer.setCpu("Intel Celeron");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("4GB DDR3");
    }

    @Override
    public void buildHardDisk() {
        computer.setHardDisk("500GB HDD");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
