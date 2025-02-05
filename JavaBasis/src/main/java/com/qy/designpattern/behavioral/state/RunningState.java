package com.qy.designpattern.behavioral.state;

// 具体状态类：运行状态
class RunningState implements ElevatorState {
    private Elevator elevator;

    public RunningState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoor() {
        System.out.println("Cannot open the door while the elevator is running.");
    }

    @Override
    public void closeDoor() {
        System.out.println("The door is already closed while the elevator is running.");
    }

    @Override
    public void run() {
        System.out.println("The elevator is already running.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the elevator...");
        elevator.setState(elevator.getStoppedState());
    }
}
