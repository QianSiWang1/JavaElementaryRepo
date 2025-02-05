package com.qy.designpattern.behavioral.observer;

// 抽象主题
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

