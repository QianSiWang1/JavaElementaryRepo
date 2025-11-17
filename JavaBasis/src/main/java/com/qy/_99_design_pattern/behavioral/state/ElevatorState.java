package com.qy._99_design_pattern.behavioral.state;

// 抽象状态类：电梯状态
interface ElevatorState {
    void openDoor();
    void closeDoor();
    void run();
    void stop();
}

