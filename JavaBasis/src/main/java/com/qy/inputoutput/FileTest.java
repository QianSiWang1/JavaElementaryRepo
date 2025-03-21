package com.qy.inputoutput;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Author QianSiWang
 * @Date 2022/8/18 21:04
 * @Description
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        String filePath = "fileTest.txt";
        // 根据指定路径创建文件对象
        File file = new File(filePath);
        file.createNewFile();
        System.out.println("文件名称:" + file.getName());
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件的相对路径：" + file.getPath());
        System.out.println("文件的绝对路径：" + file.getAbsolutePath());
        System.out.println("是否为可执行文件：" + file.canExecute());
        System.out.println("文件可以读取：" + file.canRead());
        System.out.println("文件可以写入：" + file.canWrite());
        System.out.println("文件上级路径：" + file.getParent());
        System.out.println("文件大小：" + file.length() + "B");
        System.out.println("文件最后修改时间：" + new Date(file.lastModified()));
        System.out.println("是否文件类型：" + file.isFile());
        System.out.println("是否为文件夹：" + file.isDirectory());
    }
}
