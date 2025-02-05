package com.qy.designpattern.create.builder;

// 指挥者
class ComputerDirector {
    private ComputerBuilder computerBuilder;

    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer constructComputer() {
        computerBuilder.buildCpu();
        computerBuilder.buildMemory();
        computerBuilder.buildHardDisk();
        return computerBuilder.getComputer();
    }
}
