package com.qy._99_design_pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

// 复合组件：文件夹
class Folder extends FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent component : children) {
            component.display();
        }
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public FileSystemComponent getChild(int index) {
        return children.get(index);
    }
}
