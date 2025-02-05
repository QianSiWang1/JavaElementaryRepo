package com.qy.designpattern.structure.facacde;

// 客户端调用
public class Client {
    public static void main(String[] args) {
        OrderFacade facade = new OrderFacade();
        facade.placeOrder("P123", 99.99, "O456");
    }
}
