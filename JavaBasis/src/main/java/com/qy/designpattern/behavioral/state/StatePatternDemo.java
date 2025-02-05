package com.qy.designpattern.behavioral.state;

// 客户端代码
public class StatePatternDemo {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        // 打开门
        elevator.openDoor();

        // 尝试运行（门开着不能运行）
        elevator.run();

        // 关闭门
        elevator.closeDoor();

        // 运行电梯
        elevator.run();

        // 停止电梯
        elevator.stop();

        // 再次打开门
        elevator.openDoor();
    }
}
