package com.qy.designpattern.behavioral.state;

// 具体状态类：停止状态
class StoppedState implements ElevatorState {
    private Elevator elevator;

    public StoppedState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoor() {
        System.out.println("Opening the door...");
        elevator.setState(elevator.getDoorOpenState());
    }

    @Override
    public void closeDoor() {
        System.out.println("The door is already closed while the elevator is stopped.");
    }

    @Override
    public void run() {
        System.out.println("Running the elevator...");
        elevator.setState(elevator.getRunningState());
    }

    @Override
    public void stop() {
        System.out.println("The elevator is already stopped.");
    }
}
