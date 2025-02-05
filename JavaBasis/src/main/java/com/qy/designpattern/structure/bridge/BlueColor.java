package com.qy.designpattern.structure.bridge;

// 具体实现化角色：蓝色
class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}
