package com.qy.designpattern.behavioral.state;

// 具体状态类：开门状态
class DoorOpenState implements ElevatorState {
    private Elevator elevator;

    public DoorOpenState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoor() {
        System.out.println("The door is already open.");
    }

    @Override
    public void closeDoor() {
        System.out.println("Closing the door...");
        elevator.setState(elevator.getDoorClosedState());
    }

    @Override
    public void run() {
        System.out.println("Cannot run with the door open.");
    }

    @Override
    public void stop() {
        System.out.println("The elevator is already stopped with the door open.");
    }
}
