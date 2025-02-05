package com.qy.designpattern.structure.facacde;

// 子系统：库存服务
class InventoryService {
    public void checkStock(String productId) {
        System.out.println("检查库存: " + productId);
    }
}

