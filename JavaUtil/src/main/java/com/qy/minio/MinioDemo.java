package com.qy.minio;

/**
 * @Author QianSiWang
 * @Date 2024/3/31 18:45
 * @Description
 */
import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import io.minio.messages.Item;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author yuqian4
 * @Date 2024/3/28 12:37
 * @Description
 **/
public class MinioDemo {
    public static final int MAX_COUNT = 20;

    public static MinioClient minioClient;

    static {
        //minioClient = MinioClient.builder().endpoint("http://172.30.94.22:9000").credentials("admin", "NvunqFcEZejjcYOhu9").build();
        minioClient = MinioClient.builder().endpoint("1111").credentials("1111", "1111").build();
    }
    public static void main(String[] args) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        //deleteFiles();
    }

    public static void uploadFile(String s) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        String bucketName = "1111";
        for(int i = 1 ; i<= 10000;i++){
            InputStream inputStream = new FileInputStream("1111.wav");
            String objectName = "11111" + i + s +"-2911"+".wav";
            // 上传文件到MinIO
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .stream(inputStream,inputStream.available(),-1)
                    .build());
            inputStream.close();
            System.out.println("文件上传成功===>" + i + s);
        }

    }

    public static void uploadFileByStream(InputStream stream) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String bucketName = "11111";
        String objectName = "1111"+".wav";
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(stream,stream.available(),-1)
                .build());
    }

    public static void deleteFiles(){
        String path = "1111";
        deleteFile(minioClient,path);
    }

    private static void deleteFile(MinioClient minioClient, String path) {
        long start = System.currentTimeMillis();
        ListObjectsArgs build = ListObjectsArgs.builder().bucket("1111").recursive(true).prefix(path).build();
        Iterable<Result<Item>> results = minioClient.listObjects(build);
        if (results == null) {
            return;
        }
        Iterator<Result<Item>> it = results.iterator();
        List<String> list = new ArrayList<>();
        int count = 0;
        while (it.hasNext()) {
            try {
                Item item = it.next().get();
                list.add(item.objectName());
                if (list.size() == MAX_COUNT) {
                    delete(minioClient, list);
                    count += MAX_COUNT;
                    list = new ArrayList<>();
                    System.out.println("删除文件数 ：" + count);
                }
            } catch (Exception e) {

            }
        }
        if (!list.isEmpty()) {
            delete(minioClient, list);
            count += list.size();
        }
        System.out.printf("删除文件耗时：%s, 总音频数：%s%n",System.currentTimeMillis() - start,count);

    }

    private static void delete(MinioClient minioClient, List<String> filePaths) {
        List<DeleteObject> list = new ArrayList<>();
        for (String filePath : filePaths) {
            list.add(new DeleteObject(filePath));
        }
        try {
            Iterable<Result<DeleteError>> iterable = minioClient.removeObjects(
                    RemoveObjectsArgs.builder().bucket("1111").objects(list).build()
            );
            for (Result<DeleteError> result : iterable) {
                DeleteError error = result.get();
            }
        } catch (Exception e) {

        }
    }
}
