package com.qy.designpattern.structure.adapter.objectadapter;

// 适配器类，持有 Adaptee 对象并实现 Target 接口
class ObjectAdapter implements Target {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
