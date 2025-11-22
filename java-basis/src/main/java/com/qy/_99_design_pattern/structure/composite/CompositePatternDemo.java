package com.qy._99_design_pattern.structure.composite;

// 客户端代码
public class CompositePatternDemo {
    public static void main(String[] args) {
        // 创建文件夹和文件
        Folder rootFolder = new Folder("Root Folder");
        File file1 = new File("File 1");
        File file2 = new File("File 2");
        Folder subFolder = new Folder("Sub Folder");
        File file3 = new File("File 3");

        // 组装文件系统
        rootFolder.add(file1);
        rootFolder.add(file2);
        rootFolder.add(subFolder);
        subFolder.add(file3);

        // 显示文件系统结构
        rootFolder.display();
    }

}
