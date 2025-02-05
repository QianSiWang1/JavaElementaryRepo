package com.qy.designpattern.behavioral.observer;

// 抽象观察者
interface Observer {
    void update(float temperature, float humidity, float pressure);
}
