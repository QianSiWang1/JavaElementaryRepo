package com.qy.designpattern.structure.composite;

// 叶子组件：文件
class File extends FileSystemComponent {
    public File(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}
