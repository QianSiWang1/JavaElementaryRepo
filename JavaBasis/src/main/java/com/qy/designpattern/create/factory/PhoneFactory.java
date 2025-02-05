package com.qy.designpattern.create.factory;

/**
 * 简单工厂模式
 */
public class PhoneFactory {
    public static Phone createPhone(String brand) {
        if ("Apple".equals(brand)) return new iPhone();
        if ("Huawei".equals(brand)) return new MateSeries();
        throw new IllegalArgumentException("Unsupported brand");
    }
}
