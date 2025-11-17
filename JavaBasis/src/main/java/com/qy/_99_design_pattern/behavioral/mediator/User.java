package com.qy._99_design_pattern.behavioral.mediator;

// 抽象同事类：用户
abstract class User {
    protected ChatRoomMediator chatRoom;
    protected String name;

    public User(ChatRoomMediator chatRoom, String name) {
        this.chatRoom = chatRoom;
        this.name = name;
        chatRoom.addUser(this);
    }

    public abstract void sendMessage(String message);

    public abstract void receiveMessage(String message);
}
