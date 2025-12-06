package _05_lock._02_lock_support;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

public class _05_GetBlockerMethod {
    // 基本使用示例
    public static void basicGetBlockerExample() throws InterruptedException {
        Object blocker = new Object() {
            @Override
            public String toString() {
                return "CustomBlocker-" + Thread.currentThread().getName();
            }
        };

        Thread thread = new Thread(() -> {
            System.out.println("线程使用 blocker: " + blocker);
            LockSupport.park(blocker);

            System.out.println("线程被唤醒");
        });

        thread.start();

        // 获取阻塞对象
        Thread.sleep(50);
        Object retrievedBlocker = LockSupport.getBlocker(thread);
        System.out.println("获取到的 blocker: " + retrievedBlocker);
        System.out.println("是否是同一个对象: " + (blocker == retrievedBlocker));

        // 唤醒线程
        LockSupport.unpark(thread);

        // 线程唤醒后再次获取
        Thread.sleep(50);
        retrievedBlocker = LockSupport.getBlocker(thread);
        System.out.println("唤醒后的 blocker: " + retrievedBlocker);

        thread.join();
    }

    // 监控线程状态
    public static void threadMonitoringExample() throws InterruptedException {
        class MonitoredThread extends Thread {
            private final String taskName;
            private final Object blocker;

            MonitoredThread(String taskName) {
                super("Worker-" + taskName);
                this.taskName = taskName;
                this.blocker = new Object() {
                    @Override
                    public String toString() {
                        return "Task-" + taskName + "-" + getId();
                    }
                };
            }

            @Override
            public void run() {
                System.out.println(getName() + " 开始任务: " + taskName);

                // 使用 blocker 进行 park
                LockSupport.park(blocker);

                System.out.println(getName() + " 完成任务");
            }

            public Object getTaskBlocker() {
                return blocker;
            }
        }

        // 创建多个监控线程
        MonitoredThread[] threads = {
                new MonitoredThread("DataProcessing"),
                new MonitoredThread("FileIO"),
                new MonitoredThread("NetworkRequest")
        };

        // 启动所有线程
        for (MonitoredThread thread : threads) {
            thread.start();
        }

        // 监控线程状态
        System.out.println("\n=== 线程状态监控 ===");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            System.out.println("\n监控时间点 " + (i + 1));

            for (MonitoredThread thread : threads) {
                Object blocker = LockSupport.getBlocker(thread);
                System.out.printf("%s: 状态=%s, 阻塞对象=%s%n",
                        thread.getName(),
                        thread.getState(),
                        blocker);
            }

            // 逐步唤醒线程
            if (i < threads.length) {
                System.out.println("唤醒 " + threads[i].getName());
                LockSupport.unpark(threads[i]);
            }
        }

        // 等待所有线程完成
        for (MonitoredThread thread : threads) {
            thread.join();
        }
    }

    // 诊断死锁问题
    public static void deadlockDiagnosisExample() throws InterruptedException {
        Object resourceA = new Object();
        Object resourceB = new Object();

        // 线程1：持有A，请求B
        Thread thread1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("Thread1 持有 ResourceA");

                // 使用 blocker 标识等待的资源
                LockSupport.park(resourceB);

                synchronized (resourceB) {
                    System.out.println("Thread1 获得 ResourceB");
                }
            }
        });

        // 线程2：持有B，请求A
        Thread thread2 = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("Thread2 持有 ResourceB");

                // 使用 blocker 标识等待的资源
                LockSupport.park(resourceA);

                synchronized (resourceA) {
                    System.out.println("Thread2 获得 ResourceA");
                }
            }
        });

        thread1.start();
        thread2.start();

        // 等待死锁发生
        Thread.sleep(1000);

        // 诊断死锁
        System.out.println("\n=== 死锁诊断 ===");
        System.out.println("Thread1 状态: " + thread1.getState());
        System.out.println("Thread1 阻塞对象: " + LockSupport.getBlocker(thread1));

        System.out.println("Thread2 状态: " + thread2.getState());
        System.out.println("Thread2 阻塞对象: " + LockSupport.getBlocker(thread2));

        // 发现死锁后，可以选择性唤醒
        System.out.println("\n尝试解决死锁：唤醒 Thread1");
        LockSupport.unpark(thread1);

        // 给一点时间观察
        Thread.sleep(500);

        // 强制结束
        thread1.interrupt();
        thread2.interrupt();

        thread1.join(1000);
        thread2.join(1000);
    }

    // 性能监控应用
    public static void performanceMonitoringExample() throws InterruptedException {
        class PerformanceMonitor extends Thread {
            private final Map<Thread, Object> threadBlockers =
                    new ConcurrentHashMap<>();
            private volatile boolean running = true;

            @Override
            public void run() {
                System.out.println("性能监控器启动");

                while (running) {
                    // 获取所有线程
                    Set<Thread> threadSet = Thread.getAllStackTraces().keySet();

                    for (Thread thread : threadSet) {
                        Object blocker = LockSupport.getBlocker(thread);
                        if (blocker != null) {
                            // 记录阻塞信息
                            threadBlockers.put(thread, blocker);

                            // 这里可以记录到日志或发送到监控系统
                            System.out.printf("[监控] %s 被 %s 阻塞%n",
                                    thread.getName(), blocker);
                        } else if (threadBlockers.containsKey(thread)) {
                            // 线程不再阻塞
                            System.out.printf("[监控] %s 解除阻塞%n",
                                    thread.getName());
                            threadBlockers.remove(thread);
                        }
                    }

                    // 间隔一段时间
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }

                System.out.println("性能监控器停止");
            }

            public void shutdown() {
                running = false;
                this.interrupt();
            }
        }

        // 创建测试线程
        Object blocker1 = new Object() {
            @Override
            public String toString() {
                return "TestBlocker-1";
            }
        };

        Object blocker2 = new Object() {
            @Override
            public String toString() {
                return "TestBlocker-2";
            }
        };

        Thread testThread1 = new Thread(() -> {
            System.out.println("TestThread1 开始");
            LockSupport.park(blocker1);
            System.out.println("TestThread1 结束");
        });

        Thread testThread2 = new Thread(() -> {
            System.out.println("TestThread2 开始");
            LockSupport.park(blocker2);
            System.out.println("TestThread2 结束");
        });

        // 启动监控器
        PerformanceMonitor monitor = new PerformanceMonitor();
        monitor.start();

        // 启动测试线程
        testThread1.start();
        testThread2.start();

        // 监控一段时间
        Thread.sleep(2500);

        // 唤醒线程
        LockSupport.unpark(testThread1);
        LockSupport.unpark(testThread2);

        // 等待线程结束
        testThread1.join();
        testThread2.join();

        // 停止监控器
        Thread.sleep(1000);
        monitor.shutdown();
        monitor.join();
    }

    // 对未启动线程的处理
    public static void unstartedThreadExample() {
        Thread thread = new Thread(() -> {
            // 空任务
        });

        // 对未启动的线程调用 getBlocker
        Object blocker = LockSupport.getBlocker(thread);
        System.out.println("未启动线程的 blocker: " + blocker);
    }

    // 对 null 线程的处理
    public static void nullThreadExample() {
        try {
            Object blocker = LockSupport.getBlocker(null);
            System.out.println("null 线程的 blocker: " + blocker);
        } catch (NullPointerException e) {
            System.out.println("getBlocker(null) 抛出 NullPointerException");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 1. 基本 getBlocker 示例 ===");
        basicGetBlockerExample();

        System.out.println("\n=== 2. 线程状态监控示例 ===");
        threadMonitoringExample();

        System.out.println("\n=== 3. 死锁诊断示例 ===");
        deadlockDiagnosisExample();

        System.out.println("\n=== 4. 性能监控应用示例 ===");
        performanceMonitoringExample();

        System.out.println("\n=== 5. 对未启动线程的处理 ===");
        unstartedThreadExample();

        System.out.println("\n=== 6. 对 null 线程的处理 ===");
        nullThreadExample();
    }
}
