package com.qy.inputoutput;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author QianSiWang
 * @Date 2024/4/8 21:19
 * @Description
 */
public class DownloadUrlFileAsZip {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("短音频23-1.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String fileName;
        InputStream inputStream = null;
        InputStream fileInputStream = null;
        File zipFile = new File("短音频23-1.zip");
        ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile.toPath()));
        while ((fileName = bufferedReader.readLine()) != null) {
            String realFileName = fileName.substring(0, fileName.length() - 1);
            String urlAddress = "https://outbound-aicc.iflyhealth.com/oss/aicc-bucket/shortAudio/2024/4/7/" + realFileName + ".wav";
            try{
                URL fileURL = new URL(urlAddress);
                URLConnection connection = fileURL.openConnection();
                inputStream = connection.getInputStream();
            }catch (Exception e){
                System.out.println(realFileName);
                continue;
            }
            File file = File.createTempFile("temp", null);
            file.deleteOnExit();
            FileUtils.copyInputStreamToFile(inputStream, file);
            fileInputStream = Files.newInputStream(file.toPath());
            ZipEntry zipEntry = new ZipEntry(realFileName + ".wav");

            zos.putNextEntry(zipEntry);
            IOUtils.copy(fileInputStream, zos);
        }
        zos.closeEntry();
        zos.close();
        bufferedReader.close();
        if (fileInputStream != null) fileInputStream.close();
        if (inputStream != null) inputStream.close();
    }

}
