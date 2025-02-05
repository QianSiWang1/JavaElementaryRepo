package com.qy.designpattern.structure.bridge;

// 具体实现化角色：红色
class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying red color");
    }
}
