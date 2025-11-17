package com.qy._99_design_pattern.structure.facacde;

// 外观类
class OrderFacade {
    private InventoryService inventory;
    private PaymentService payment;
    private ShippingService shipping;

    public OrderFacade() {
        this.inventory = new InventoryService();
        this.payment = new PaymentService();
        this.shipping = new ShippingService();
    }

    public void placeOrder(String productId, double amount, String orderId) {
        inventory.checkStock(productId);
        payment.processPayment(amount);
        shipping.shipOrder(orderId);
        System.out.println("订单完成！");
    }
}
