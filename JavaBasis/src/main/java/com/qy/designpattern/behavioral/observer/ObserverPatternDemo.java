package com.qy.designpattern.behavioral.observer;

// 客户端代码
public class ObserverPatternDemo {
    public static void main(String[] args) {
        // 创建主题
        WeatherSubject weatherSubject = new WeatherSubject();

        // 创建观察者
        WeatherStation station1 = new WeatherStation("Station 1");
        WeatherStation station2 = new WeatherStation("Station 2");

        // 注册观察者
        weatherSubject.registerObserver(station1);
        weatherSubject.registerObserver(station2);

        // 模拟天气变化
        weatherSubject.setMeasurements(25.0f, 60.0f, 1013.25f);

        // 移除一个观察者
        weatherSubject.removeObserver(station2);

        // 再次模拟天气变化
        weatherSubject.setMeasurements(26.0f, 62.0f, 1012.5f);
    }
}
