package com.qy.jdk21.thread;

import java.util.concurrent.Executors;

public class TestThread {
    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> {
                System.out.println("hello world");
            });
        }
        // 给虚拟线程一些时间来执行
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
