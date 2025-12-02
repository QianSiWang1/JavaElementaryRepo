package _01_thread._01_thread_method;

/**
 * join()方法详解：
 * 1. 让当前线程等待目标线程完成
 * 2. 可用于协调多个线程的执行顺序
 * 3. 提供超时机制，避免无限等待
 *
 * @author qy
 */
public class _05_ThreadJoin {
    public static void main(String[] args) {

    }
    /**
     * 基础用法：等待线程完成
     */
    public static void basicJoin() throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("工作线程开始执行...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("工作线程执行完成");
        });

        worker.start();
        System.out.println("主线程等待工作线程完成...");
        worker.join(); // 主线程会阻塞，直到worker完成
        System.out.println("主线程继续执行");
    }

    /**
     * 带超时的join
     */
    public static void joinWithTimeout() throws InterruptedException {
        Thread slowWorker = new Thread(() -> {
            try {
                Thread.sleep(5000); // 执行5秒
            } catch (InterruptedException e) {
                System.out.println("工作线程被中断");
            }
        });

        slowWorker.start();

        // 最多等待2秒
        long start = System.currentTimeMillis();
        slowWorker.join(2000);
        long elapsed = System.currentTimeMillis() - start;

        if (slowWorker.isAlive()) {
            System.out.println("等待超时，已等待 " + elapsed + "ms");
            slowWorker.interrupt();
        } else {
            System.out.println("工作线程在 " + elapsed + "ms 内完成");
        }
    }

    /**
     * 协调多个线程
     */
    public static void coordinateMultipleThreads() throws InterruptedException {
        Thread task1 = new Thread(() -> {
            System.out.println("任务1开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("任务1完成");
        });

        Thread task2 = new Thread(() -> {
            try {
                task1.join(); // 任务2等待任务1完成
                System.out.println("任务2开始");
                Thread.sleep(500);
                System.out.println("任务2完成");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        task1.start();
        task2.start();

        // 主线程等待两个任务都完成
        task1.join();
        task2.join();
        System.out.println("所有任务完成");

    }
}
