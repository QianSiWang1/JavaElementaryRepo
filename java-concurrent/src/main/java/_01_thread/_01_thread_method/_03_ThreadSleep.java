package _01_thread._01_thread_method;
/**
 * sleep() 方法详解：
 * 1. 使当前线程暂停执行指定的时间
 * 2. 不释放锁（如果持有锁）
 * 3. 会响应中断
 * @author qy
 */
public class _03_ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        //basicSleep();
        //sleepWithLock();
        preciseSleep(520);
        //sleepAccuracy();
    }
    /**
     * 基本用法
     */
    public static void basicSleep() {
        System.out.println("开始时间: " + System.currentTimeMillis());

        try {
            // 睡眠1秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("结束时间: " + System.currentTimeMillis());
    }

    /**
     * sleep不释放锁
     */
    public static void sleepWithLock() {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("T1获取锁，开始sleep");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("T1释放锁");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("T2获取锁");
            }
        });

        t1.start();
        t2.start();

        // 输出顺序：
        // T1获取锁，开始sleep
        // (等待3秒)
        // T1释放锁
        // T2获取锁
    }

    /**
     * 精确控制sleep时间
     */
    public static void preciseSleep(long millis) throws InterruptedException {
        long start = System.nanoTime();
        long deadline = start + millis * 1_000_000L;

        long remaining = millis;
        while (remaining > 0) {
            Thread.sleep(remaining);
            long elapsed = (System.nanoTime() - start) / 1_000_000L;
            remaining = millis - elapsed;
        }
    }

    /**
     * sleep的精度问题
     */
    public static void sleepAccuracy() {
        int iterations = 10;
        long totalDeviation = 0;

        for (int i = 0; i < iterations; i++) {
            long start = System.nanoTime();
            try {
                // 期望睡眠10ms
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            long actual = (System.nanoTime() - start) / 1_000_000L;
            long deviation = Math.abs(actual - 10);
            totalDeviation += deviation;
            System.out.printf("第%d次: 期望10ms, 实际%3dms, 偏差%2dms%n",
                    i + 1, actual, deviation);
        }

        System.out.printf("平均偏差: %.2fms%n", (double) totalDeviation / iterations);
    }

}
