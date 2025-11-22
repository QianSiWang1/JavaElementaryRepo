package com.qy._99_design_pattern.behavioral.state;

// 上下文类：电梯
class Elevator {
    private ElevatorState doorOpenState;
    private ElevatorState doorClosedState;
    private ElevatorState runningState;
    private ElevatorState stoppedState;
    private ElevatorState currentState;

    public Elevator() {
        doorOpenState = new DoorOpenState(this);
        doorClosedState = new DoorClosedState(this);
        runningState = new RunningState(this);
        stoppedState = new StoppedState(this);
        currentState = stoppedState;
    }

    public void setState(ElevatorState state) {
        this.currentState = state;
    }

    public ElevatorState getDoorOpenState() {
        return doorOpenState;
    }

    public ElevatorState getDoorClosedState() {
        return doorClosedState;
    }

    public ElevatorState getRunningState() {
        return runningState;
    }

    public ElevatorState getStoppedState() {
        return stoppedState;
    }

    public void openDoor() {
        currentState.openDoor();
    }

    public void closeDoor() {
        currentState.closeDoor();
    }

    public void run() {
        currentState.run();
    }

    public void stop() {
        currentState.stop();
    }
}
