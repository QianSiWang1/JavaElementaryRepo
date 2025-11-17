package com.qy._99_design_pattern.behavioral.observer;

// 抽象主题
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

