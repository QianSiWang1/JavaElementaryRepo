package com.qy.designpattern.structure.facacde;

// 子系统：物流服务
class ShippingService {
    public void shipOrder(String orderId) {
        System.out.println("发货: " + orderId);
    }
}
