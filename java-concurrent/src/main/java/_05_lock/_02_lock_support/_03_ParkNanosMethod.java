package _05_lock._02_lock_support;

import java.util.concurrent.locks.LockSupport;

public class _03_ParkNanosMethod {
    // 基本使用示例
    public static void basicParkNanosExample() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始，将阻塞 1.5 秒");

            long start = System.nanoTime();

            // 阻塞 1.5 秒 (1,500,000,000 纳秒)
            LockSupport.parkNanos(1_500_000_000L);

            long end = System.nanoTime();
            long elapsed = end - start;

            System.out.println("线程恢复，实际阻塞: " +
                    elapsed / 1_000_000 + " 毫秒");
            System.out.println("与期望的偏差: " +
                    (elapsed - 1_500_000_000L) / 1_000_000 + " 毫秒");
        });

        thread.start();
        thread.join();
    }

    // 超时精度测试
    public static void timeoutAccuracyTest() throws InterruptedException {
        final int testCount = 10;
        final long timeoutNanos = 100_000_000L; // 100毫秒

        Thread thread = new Thread(() -> {
            long totalError = 0;
            long maxError = 0;
            long minError = Long.MAX_VALUE;

            for (int i = 0; i < testCount; i++) {
                long start = System.nanoTime();
                LockSupport.parkNanos(timeoutNanos);
                long end = System.nanoTime();

                long actualNanos = end - start;
                long error = actualNanos - timeoutNanos;

                totalError += Math.abs(error);
                maxError = Math.max(maxError, Math.abs(error));
                minError = Math.min(minError, Math.abs(error));

                System.out.printf("测试 %d: 期望 %.1fms, 实际 %.1fms, 误差 %.1fms%n",
                        i + 1,
                        timeoutNanos / 1_000_000.0,
                        actualNanos / 1_000_000.0,
                        error / 1_000_000.0);

                try {
                    Thread.sleep(10); // 避免连续测试影响结果
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            System.out.printf("%n统计结果:%n");
            System.out.printf("平均误差: %.1fms%n",
                    (totalError / testCount) / 1_000_000.0);
            System.out.printf("最大误差: %.1fms%n",
                    maxError / 1_000_000.0);
            System.out.printf("最小误差: %.1fms%n",
                    minError / 1_000_000.0);
        });

        thread.start();
        thread.join();
    }

    // parkNanos 与中断的交互
    public static void parkNanosInterruptExample() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始，将阻塞 5 秒");

            long start = System.nanoTime();

            try {
                // 阻塞 5 秒
                LockSupport.parkNanos(5_000_000_000L);
            } finally {
                long end = System.nanoTime();
                long elapsed = (end - start) / 1_000_000;

                System.out.println("线程结束，实际运行: " + elapsed + " 毫秒");
                System.out.println("中断状态: " + Thread.currentThread().isInterrupted());
            }
        });

        thread.start();

        // 2秒后中断线程
        Thread.sleep(2000);
        System.out.println("主线程中断工作线程");
        thread.interrupt();

        thread.join();
    }

    // parkNanos 与 unpark 的交互
    public static void parkNanosUnparkExample() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始，将阻塞 3 秒");

            long start = System.nanoTime();
            LockSupport.parkNanos(3_000_000_000L);
            long end = System.nanoTime();

            long elapsed = (end - start) / 1_000_000;
            System.out.println("实际阻塞: " + elapsed + " 毫秒");
        });

        thread.start();

        // 1秒后唤醒线程
        Thread.sleep(1000);
        System.out.println("主线程提前唤醒工作线程");
        LockSupport.unpark(thread);

        thread.join();
    }

    // 短时间 parkNanos 的使用场景
    public static void shortParkNanosExample() throws InterruptedException {
        final int iterations = 1000;
        final long shortSleepNanos = 10_000L; // 10微秒

        Thread thread = new Thread(() -> {
            long totalParkTime = 0;
            int parkCount = 0;

            for (int i = 0; i < iterations; i++) {
                // 模拟一些工作
                int sum = 0;
                for (int j = 0; j < 1000; j++) {
                    sum += j;
                }

                // 短暂 park，让出 CPU
                long start = System.nanoTime();
                LockSupport.parkNanos(shortSleepNanos);
                long end = System.nanoTime();

                totalParkTime += (end - start);
                parkCount++;
            }

            System.out.println("短暂 park 统计:");
            System.out.println("总 park 次数: " + parkCount);
            System.out.println("平均 park 时间: " +
                    (totalParkTime / parkCount) / 1_000.0 + " 微秒");
        });

        thread.start();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 1. 基本 parkNanos 示例 ===");
        basicParkNanosExample();

        System.out.println("\n=== 2. 超时精度测试 ===");
        timeoutAccuracyTest();

        System.out.println("\n=== 3. parkNanos 与中断交互 ===");
        parkNanosInterruptExample();

        System.out.println("\n=== 4. parkNanos 与 unpark 交互 ===");
        parkNanosUnparkExample();

        System.out.println("\n=== 5. 短时间 parkNanos 示例 ===");
        shortParkNanosExample();
    }
}
