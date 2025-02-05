package com.qy.designpattern.behavioral.command;

// 客户端代码
public class CommandPatternDemo {
    public static void main(String[] args) {
        // 创建接收者
        Light light = new Light();

        // 创建具体命令对象
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        // 创建调用者
        RemoteControl remoteControl = new RemoteControl();

        // 设置开灯命令并执行
        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton();

        // 撤销开灯命令
        remoteControl.pressUndoButton();

        // 设置关灯命令并执行
        remoteControl.setCommand(lightOffCommand);
        remoteControl.pressButton();

        // 撤销关灯命令
        remoteControl.pressUndoButton();
    }
}
