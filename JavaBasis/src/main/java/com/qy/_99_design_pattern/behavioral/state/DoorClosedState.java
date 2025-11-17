package com.qy._99_design_pattern.behavioral.state;

// 具体状态类：关门状态
class DoorClosedState implements ElevatorState {
    private Elevator elevator;

    public DoorClosedState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoor() {
        System.out.println("Opening the door...");
        elevator.setState(elevator.getDoorOpenState());
    }

    @Override
    public void closeDoor() {
        System.out.println("The door is already closed.");
    }

    @Override
    public void run() {
        System.out.println("Running the elevator...");
        elevator.setState(elevator.getRunningState());
    }

    @Override
    public void stop() {
        System.out.println("The elevator is already stopped with the door closed.");
    }
}
