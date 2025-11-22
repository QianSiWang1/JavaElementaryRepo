package com.qy._03_lambda_stream;

/**
 * @Author QianSiWang
 * @Date 2022/7/31 14:16
 * @Description 简单的Lambda表达式的用法示例
 */
public class _01_SimpleLambda {
    public static void main(String[] args) {

        //使用匿名内部类的方式,实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 使用匿名内部类创建新线程");
            }
        }).start();

        //使用Lambda表达式,实现多线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 新线程创建了");
        }
        ).start();

        //优化省略Lambda
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " 新线程创建了")).start();
    }
}

