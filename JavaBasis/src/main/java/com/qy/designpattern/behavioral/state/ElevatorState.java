package com.qy.designpattern.behavioral.state;

// 抽象状态类：电梯状态
interface ElevatorState {
    void openDoor();
    void closeDoor();
    void run();
    void stop();
}

