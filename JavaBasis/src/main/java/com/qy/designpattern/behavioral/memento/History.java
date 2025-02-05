package com.qy.designpattern.behavioral.memento;

// 管理者类：历史记录
class History {
    private java.util.Stack<Memento> mementos = new java.util.Stack<>();

    public void saveMemento(Memento memento) {
        mementos.push(memento);
    }

    public Memento getMemento() {
        if (!mementos.isEmpty()) {
            return mementos.pop();
        }
        return null;
    }
}
