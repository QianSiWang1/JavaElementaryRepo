package com.qy._99_design_pattern.structure.facacde;

// 客户端调用
public class Client {
    public static void main(String[] args) {
        OrderFacade facade = new OrderFacade();
        facade.placeOrder("P123", 99.99, "O456");
    }
}
