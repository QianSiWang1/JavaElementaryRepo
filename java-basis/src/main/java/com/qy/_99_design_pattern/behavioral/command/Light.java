package com.qy._99_design_pattern.behavioral.command;

// 接收者：电灯
class Light {
    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }
}
