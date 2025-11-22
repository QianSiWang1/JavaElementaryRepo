package com.qy._99_design_pattern.behavioral.mediator;

// 客户端代码
public class MediatorPatternDemo {
    public static void main(String[] args) {
        // 创建聊天室
        ChatRoomMediator chatRoom = new ConcreteChatRoom();

        // 创建用户
        User user1 = new ConcreteUser(chatRoom, "Alice");
        User user2 = new ConcreteUser(chatRoom, "Bob");
        User user3 = new ConcreteUser(chatRoom, "Charlie");

        // 用户发送消息
        user1.sendMessage("Hello, everyone!");
        user2.sendMessage("Hi, Alice!");
    }
}
