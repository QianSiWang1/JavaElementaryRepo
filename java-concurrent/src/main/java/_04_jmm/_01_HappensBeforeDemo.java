package _04_jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qy
 */
public class _01_HappensBeforeDemo {

    // ========== 1. 程序次序规则 ==========
    // 单线程内，书写在前面的操作 happens-before 后面的操作
    public void programOrderRule() {
        int x = 10;     // ① happens-before ②
        int y = x + 5;  // ②

        x = 20;         // ③ happens-before ④
        y = 30;         // ④

        // 但编译器可能会重排序①和③，因为它们没有依赖关系
        // 单线程结果不变：x=20, y=30
    }

    // ========== 2. 管程锁定规则 ==========
    // unlock操作happens-before后续对同一个锁的lock操作
    private final Object lock = new Object();
    private int sharedValue = 0;

    public void monitorLockRule() {
        // 线程A
        new Thread(() -> {
            synchronized(lock) {
                sharedValue = 100;  // 写操作
                // 解锁时，这个值会刷新到主内存
            } // unlock操作 happens-before 线程B的lock操作
        }).start();

        // 线程B
        new Thread(() -> {
            try {
                Thread.sleep(10); // 确保线程A先执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized(lock) { // lock操作
                // 一定能看到sharedValue = 100
                System.out.println("Monitored value: " + sharedValue);
            }
        }).start();
    }

    // ========== 3. volatile变量规则 ==========
    // 对volatile变量的写happens-before后续对它的读
    private volatile boolean flag = false;
    private int data = 0;

    public void volatileRule() {
        // 写线程
        new Thread(() -> {
            data = 42;      // ① 普通写
            flag = true;    // ② volatile写 happens-before 读线程的读
        }).start();

        // 读线程
        new Thread(() -> {
            while (!flag) {
                // 等待flag变为true
            }
            // 这里一定能看到 data = 42
            System.out.println("Volatile data: " + data);
        }).start();
    }

    // ========== 4. 线程启动规则 ==========
    // Thread.start() happens-before 线程中的任何操作
    private String message = "";

    public void threadStartRule() {
        message = "Hello from main thread"; // ①

        Thread thread = new Thread(() -> {
            // 这里能看到 ① 的写操作
            System.out.println("Message in new thread: " + message);
        });

        thread.start(); // ② happens-before 线程中的所有操作
    }

    // ========== 5. 线程终止规则 ==========
    // 线程中的所有操作 happens-before 其他线程检测到该线程已终止
    public void threadTerminationRule() throws InterruptedException {
        AtomicInteger result = new AtomicInteger(0);

        Thread worker = new Thread(() -> {
            // 做一些工作
            result.set(42); // 线程内部的操作
        });

        worker.start();
        worker.join(); // join() 调用 happens-before join() 返回

        // 这里一定能看到 result = 42
        System.out.println("Result after join: " + result.get());
    }

    // ========== 6. 线程中断规则 ==========
    // 对线程interrupt()的调用 happens-before 被中断线程检测到中断
    public void threadInterruptRule() throws InterruptedException {
        Thread worker = new Thread(() -> {
            // 检查中断状态
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000); // 可中断的方法
                } catch (InterruptedException e) {
                    // 中断发生时，能感知到interrupt()的调用
                    System.out.println("Thread interrupted, exiting...");
                    Thread.currentThread().interrupt(); // 恢复中断状态
                    break;
                }
            }
        });

        worker.start();
        Thread.sleep(50); // 确保worker线程已经启动

        worker.interrupt(); // happens-before worker检测到中断
        worker.join();
    }

    // ========== 7. 对象终结规则 ==========
    // 对象的构造函数执行结束 happens-before finalize()方法开始
    static class Resource {
        private final int id;

        public Resource(int id) {
            this.id = id;
            System.out.println("Resource " + id + " created");
        }

        @Override
        protected void finalize() throws Throwable {
            // 这里能看到构造函数完成的所有初始化
            System.out.println("Resource " + id + " finalized");
            super.finalize();
        }
    }

    public void objectFinalizationRule() {
        Resource resource = new Resource(1);
        resource = null; // 使对象可被GC
        System.gc();     // 建议GC，但不保证立即执行

        try {
            Thread.sleep(1000); // 给GC一点时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ========== 8. 传递性规则 ==========
    // 如果A happens-before B，B happens-before C，那么A happens-before C
    private volatile boolean started = false;
    private int value1 = 0;
    private int value2 = 0;

    public void transitivityRule() {
        // 线程A
        new Thread(() -> {
            value1 = 10;           // 操作A
            started = true;        // 操作B (volatile写)
            // A happens-before B
        }).start();

        // 线程B
        new Thread(() -> {
            while (!started) {
                // 等待
            }
            // 操作C (volatile读) happens-before D
            value2 = value1 + 5;   // 操作D

            // 根据传递性：A happens-before D
            // 所以一定能看到 value1 = 10, value2 = 15
            System.out.println("value1=" + value1 + ", value2=" + value2);
        }).start();
    }

    // ========== 综合示例：双重检查锁定的正确实现 ==========
    public static class SafeDoubleCheckedLocking {
        // volatile关键字确保happens-before关系
        private static volatile SafeDoubleCheckedLocking instance;

        private int data;

        private SafeDoubleCheckedLocking() {
            this.data = 42;
        }

        public static SafeDoubleCheckedLocking getInstance() {
            if (instance == null) {                     // 第一次检查（无锁）
                synchronized (SafeDoubleCheckedLocking.class) { // 加锁
                    if (instance == null) {             // 第二次检查（有锁）
                        // 1. 分配内存
                        // 2. 初始化对象
                        // 3. 将引用赋值给instance
                        // 由于volatile，禁止2和3的重排序
                        instance = new SafeDoubleCheckedLocking();
                    }
                }
            }
            return instance;
        }

        public int getData() {
            return data; // 一定能看到完全初始化的对象
        }
    }

    // ========== 测试所有规则 ==========
    public static void main(String[] args) throws InterruptedException {
        _01_HappensBeforeDemo demo = new _01_HappensBeforeDemo();

        System.out.println("=== 1. 程序次序规则 ===");
        demo.programOrderRule();

        System.out.println("\n=== 2. 管程锁定规则 ===");
        demo.monitorLockRule();
        Thread.sleep(100);

        System.out.println("\n=== 3. volatile变量规则 ===");
        demo.volatileRule();
        Thread.sleep(100);

        System.out.println("\n=== 4. 线程启动规则 ===");
        demo.threadStartRule();
        Thread.sleep(100);

        System.out.println("\n=== 5. 线程终止规则 ===");
        demo.threadTerminationRule();

        System.out.println("\n=== 6. 线程中断规则 ===");
        demo.threadInterruptRule();

        System.out.println("\n=== 7. 对象终结规则 ===");
        demo.objectFinalizationRule();

        System.out.println("\n=== 8. 传递性规则 ===");
        demo.transitivityRule();
        Thread.sleep(100);

        System.out.println("\n=== 综合示例：双重检查锁 ===");
        SafeDoubleCheckedLocking instance = SafeDoubleCheckedLocking.getInstance();
        System.out.println("Data from singleton: " + instance.getData());
    }
}
