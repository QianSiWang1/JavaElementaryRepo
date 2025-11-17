package com.qy._99_design_pattern.structure.adapter.classadapter;

// 适配器类，继承 Adaptee 并实现 Target 接口
class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        this.specificRequest();
    }
}
