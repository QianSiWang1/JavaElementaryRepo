package com.qy._99_design_pattern.behavioral.mediator;

// 具体同事类：具体用户
class ConcreteUser extends User {
    public ConcreteUser(ChatRoomMediator chatRoom, String name) {
        super(chatRoom, name);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " sends message: " + message);
        chatRoom.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " receives message: " + message);
    }
}
