package com.qy.designpattern.create.builder;

// 产品类：电脑
class Computer {
    private String cpu;
    private String memory;
    private String hardDisk;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    @Override
    public String toString() {
        return "Computer [CPU: " + cpu + ", Memory: " + memory + ", Hard Disk: " + hardDisk + "]";
    }
}

