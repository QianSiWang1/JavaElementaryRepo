package com.qy._08_io;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @Author yuqian4
 * @Date 2024/5/9 16:16
 * @Description
 **/
public class ZipDemo {
    public static void main(String[] args) throws IOException {
        createWithDirectoryZip();
        createWithoutDirectoryZip();
        readZipFile("without-directory.zip");
        readZipFile("with-directory.zip");
    }

    private static void createBigZip() throws IOException {
        FileInputStream fileInputStream = null;
        List<File> innerZips = createInnerZip();
        File outerZip = new File("outer.zip");
        ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(outerZip.toPath()));
        for (int i = 0; i < innerZips.size(); i++) {
            ZipEntry zipEntry = new ZipEntry("outer" + i + ".zip");
            fileInputStream = new FileInputStream(innerZips.get(i));
            zipOutputStream.putNextEntry(zipEntry);
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fileInputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, len);
            }
        }
        zipOutputStream.closeEntry();
        zipOutputStream.close();
    }

    private static List<File> createInnerZip() throws IOException {
        FileInputStream fileInputStream = null;
        List<File> innerZips = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            File innerZip = File.createTempFile("temp", null);
            ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(innerZip.toPath()));
            zos.putNextEntry(new ZipEntry("test" + i + "/"));
            zos.putNextEntry(new ZipEntry("test" + i + "/" + "text.txt"));
            fileInputStream = new FileInputStream("d.txt");
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fileInputStream.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            zos.closeEntry();
            zos.close();
            innerZips.add(innerZip);
        }
        return innerZips;
    }

    private static void createWithDirectoryZip() throws IOException {
        FileInputStream fileInputStream = null;
        File zip = new File("with-directory.zip");
        ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zip.toPath()));
        zos.putNextEntry(new ZipEntry("test-with-directory" + "/"));
        zos.putNextEntry(new ZipEntry("test-with-directory" + "/" + "text.txt"));
        fileInputStream = new FileInputStream("d.txt");
        int len;
        byte[] buffer = new byte[1024];
        while ((len = fileInputStream.read(buffer)) > 0) {
            zos.write(buffer, 0, len);
        }
        zos.closeEntry();
        zos.close();
    }

    private static void createWithoutDirectoryZip() throws IOException {
        FileInputStream fileInputStream = null;
        File zip = new File("without-directory.zip");
        ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zip.toPath()));
        zos.putNextEntry(new ZipEntry("test-without-directory" + "/" + "text.txt"));
        fileInputStream = new FileInputStream("d.txt");
        int len;
        byte[] buffer = new byte[1024];
        while ((len = fileInputStream.read(buffer)) > 0) {
            zos.write(buffer, 0, len);
        }
        zos.closeEntry();
        zos.close();
    }

    private static void readZipFile(String filePath){
        try {
            ZipFile zipFile = new ZipFile(filePath);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.isDirectory()) {
                    System.out.println("Directory: " + entry.getName());
                } else {
                    System.out.println("File: " + entry.getName());
                }
            }
            zipFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
