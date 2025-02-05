package com.qy.designpattern.behavioral.mediator;

// 具体中介者：具体聊天室
class ConcreteChatRoom implements ChatRoomMediator {
    private java.util.ArrayList<User> users;

    public ConcreteChatRoom() {
        this.users = new java.util.ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
