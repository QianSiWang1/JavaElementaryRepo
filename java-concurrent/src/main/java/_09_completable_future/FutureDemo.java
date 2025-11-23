package _09_completable_future;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        // 快速创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        // 获取商品基本信息（可以使用Lambda表达式简化Callable接口，这里为了便于观察不使用）
        Future<String> future1 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "获取到商品基本信息";
            }
        });
        // 获取商品图片信息
        Future<String> future2 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "获取商品图片信息";
            }
        });
        // 获取商品促销信息
        Future<String> future3 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "获取商品促销信息";
            }
        });
        // 获取商品各种类基本信息
        Future<String> future4 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "获取商品各种类基本信息";
            }
        });
        // 获取结果
        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
            System.out.println(future4.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }

}
