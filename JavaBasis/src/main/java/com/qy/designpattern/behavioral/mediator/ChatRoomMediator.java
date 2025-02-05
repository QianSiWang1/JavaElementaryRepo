package com.qy.designpattern.behavioral.mediator;

// 抽象中介者：聊天室
interface ChatRoomMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

