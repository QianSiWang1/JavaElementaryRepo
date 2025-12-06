package _05_lock._02_lock_support;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author qy
 */
public class _04_UnparkMethod {
    // 基本使用示例
    public static void basicUnparkExample() throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("Worker: 开始工作");

            System.out.println("Worker: 调用 park() 等待许可");
            LockSupport.park();

            System.out.println("Worker: 获得许可，继续工作");
        });

        worker.start();

        // 主线程等待后给予许可
        Thread.sleep(1000);
        System.out.println("Main: 给予 worker 许可");
        LockSupport.unpark(worker);

        worker.join();
    }

    // 许可不累加的特性
    public static void permitNotAccumulatedExample() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("开始测试许可累加");

            // 第一次 park
            System.out.println("第一次 park()");
            LockSupport.park();
            System.out.println("第一次被唤醒");

            // 第二次 park
            System.out.println("第二次 park()");
            LockSupport.park();
            System.out.println("第二次被唤醒");

            // 第三次 park
            System.out.println("第三次 park()");
            LockSupport.park();
            System.out.println("第三次被唤醒");
        });

        thread.start();

        // 主线程连续调用 unpark
        Thread.sleep(100);
        System.out.println("Main: 第一次 unpark");
        LockSupport.unpark(thread);

        System.out.println("Main: 第二次 unpark（不会累加）");
        LockSupport.unpark(thread);

        // 需要再调用一次才能唤醒第二次 park
        Thread.sleep(100);
        System.out.println("Main: 第三次 unpark");
        LockSupport.unpark(thread);

        // 需要第四次 unpark 才能唤醒第三次 park
        Thread.sleep(100);
        System.out.println("Main: 第四次 unpark");
        LockSupport.unpark(thread);

        thread.join();
    }

    // 先 unpark 后 park
    public static void unparkBeforeParkExample() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始");

            // 主线程会在启动前先调用 unpark
            try {
                Thread.sleep(100); // 确保主线程先执行 unpark
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("线程调用 park()");
            LockSupport.park(); // 立即返回，因为已经有许可

            System.out.println("线程立即从 park() 返回");

            // 再次 park 会阻塞
            System.out.println("再次 park()");
            LockSupport.park();
            System.out.println("需要新的许可才能看到这行");
        });

        // 先 unpark
        System.out.println("Main: 在启动线程前先 unpark");
        LockSupport.unpark(thread);

        thread.start();

        // 给予第二个许可
        Thread.sleep(200);
        System.out.println("Main: 给予第二个许可");
        LockSupport.unpark(thread);

        thread.join();
    }

    // 对 null 线程的处理
    public static void unparkNullThreadExample() {
        System.out.println("测试 unpark(null)");

        // 对 null 调用 unpark 是安全的
        LockSupport.unpark(null);

        System.out.println("unpark(null) 执行完成，没有异常");
    }

    // 对已终止线程的处理
    public static void unparkTerminatedThreadExample() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程运行并结束");
        });

        thread.start();
        thread.join();

        System.out.println("线程状态: " + thread.getState());

        // 对已终止线程调用 unpark
        LockSupport.unpark(thread);
        System.out.println("对已终止线程调用 unpark 完成");
    }

    // 多线程协调示例
    public static void multiThreadCoordinationExample() throws InterruptedException {
        final int workerCount = 3;
        Thread[] workers = new Thread[workerCount];
        AtomicInteger completedCount = new AtomicInteger(0);

        // 创建协调线程
        Thread coordinator = new Thread(() -> {
            System.out.println("协调者: 等待所有工作线程完成");

            // 等待所有工作线程完成
            while (completedCount.get() < workerCount) {
                LockSupport.park();
            }

            System.out.println("协调者: 所有工作完成，进行汇总");
        });

        coordinator.start();

        // 创建工作线程
        for (int i = 0; i < workerCount; i++) {
            final int workerId = i;
            workers[i] = new Thread(() -> {
                System.out.println("Worker-" + workerId + ": 开始工作");

                try {
                    Thread.sleep(1000 + workerId * 500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Worker-" + workerId + ": 工作完成");
                completedCount.incrementAndGet();

                // 通知协调者
                LockSupport.unpark(coordinator);
            });

            workers[i].start();
        }

        // 等待所有线程完成
        coordinator.join();
        for (Thread worker : workers) {
            worker.join();
        }

        System.out.println("所有任务完成");
    }

    // 避免死锁的唤醒模式
    public static void deadlockAvoidanceExample() throws InterruptedException {
        Object lockA = new Object();
        Object lockB = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread1 获取 lockA");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Thread1 尝试获取 lockB");
                synchronized (lockB) {
                    System.out.println("Thread1 获取 lockB");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            // 使用 LockSupport 避免死锁
            System.out.println("Thread2 等待 Thread1 完成");
            LockSupport.park();

            System.out.println("Thread2 被唤醒，安全获取锁");
            synchronized (lockB) {
                System.out.println("Thread2 获取 lockB");
                synchronized (lockA) {
                    System.out.println("Thread2 获取 lockA");
                }
            }
        });

        thread1.start();
        thread2.start();

        // 等待 thread1 完成后再唤醒 thread2
        thread1.join();
        System.out.println("Thread1 完成，唤醒 Thread2");
        LockSupport.unpark(thread2);

        thread2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 1. 基本 unpark 示例 ===");
        basicUnparkExample();

        System.out.println("\n=== 2. 许可不累加示例 ===");
        permitNotAccumulatedExample();

        System.out.println("\n=== 3. 先 unpark 后 park 示例 ===");
        unparkBeforeParkExample();

        System.out.println("\n=== 4. 对 null 线程的处理 ===");
        unparkNullThreadExample();

        System.out.println("\n=== 5. 对已终止线程的处理 ===");
        unparkTerminatedThreadExample();

        System.out.println("\n=== 6. 多线程协调示例 ===");
        multiThreadCoordinationExample();

        System.out.println("\n=== 7. 避免死锁的唤醒模式 ===");
        deadlockAvoidanceExample();
    }
}
