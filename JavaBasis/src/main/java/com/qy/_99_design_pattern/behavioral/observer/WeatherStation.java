package com.qy._99_design_pattern.behavioral.observer;

// 具体观察者：气象站
class WeatherStation implements Observer {
    private String name;

    public WeatherStation(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println(name + " received weather update: Temperature = " + temperature +
                ", Humidity = " + humidity + ", Pressure = " + pressure);
    }
}
