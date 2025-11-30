package _01_thread;

public class _01_ThreadDemo01 {
    public static void main(String[] args) {
        // 创建两个任务
        Runnable task1 = () -> System.out.println("Task 1 executed by: " + Thread.currentThread().getName());
        Runnable task2 = () -> System.out.println("Task 2 executed by: " + Thread.currentThread().getName());

        // 创建两个线程
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // 启动线程 - 这里开始了并发执行
        thread1.start();
        thread2.start();
    }
}
