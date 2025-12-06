package _05_lock._02_lock_support;

import java.util.concurrent.locks.LockSupport;

/**
 * @author qy
 */
public class _02_ParkWithBlocker {
    // 基本使用示例
    public static void basicParkWithBlocker() throws InterruptedException {
        // 创建有意义的阻塞对象
        Object lock = new Object() {
            @Override
            public String toString() {
                return "DatabaseConnectionPool-WaitingLock";
            }
        };

        Thread thread = new Thread(() -> {
            System.out.println("线程使用阻塞对象: " + lock);
            LockSupport.park(lock);
            System.out.println("线程被唤醒");
        });

        thread.start();

        // 获取阻塞对象信息
        Thread.sleep(50);
        Object blocker = LockSupport.getBlocker(thread);
        System.out.println("获取到的阻塞对象: " + blocker);

        // 唤醒线程
        LockSupport.unpark(thread);
        thread.join();
    }

    // 使用不同的阻塞对象
    public static void multipleBlockersExample() throws InterruptedException {
        Thread thread = new Thread(() -> {
            Object blocker1 = new Object() {
                @Override
                public String toString() {
                    return "Phase1-Initialization";
                }
            };

            Object blocker2 = new Object() {
                @Override
                public String toString() {
                    return "Phase2-Processing";
                }
            };

            System.out.println("阶段1: 使用阻塞对象 " + blocker1);
            LockSupport.park(blocker1);
            System.out.println("阶段1完成");

            System.out.println("阶段2: 使用阻塞对象 " + blocker2);
            LockSupport.park(blocker2);
            System.out.println("阶段2完成");
        });

        thread.start();

        // 监控线程状态
        Thread.sleep(50);
        System.out.println("当前阻塞对象: " + LockSupport.getBlocker(thread));

        // 唤醒第一阶段
        LockSupport.unpark(thread);
        Thread.sleep(100);

        // 检查阻塞对象变化
        System.out.println("当前阻塞对象: " + LockSupport.getBlocker(thread));

        // 唤醒第二阶段
        LockSupport.unpark(thread);

        thread.join();
    }

    // 阻塞对象在调试中的应用
    public static void debuggingExample() throws InterruptedException {
        class Resource {
            private final String name;
            private final Object waitBlocker;

            Resource(String name) {
                this.name = name;
                this.waitBlocker = new Object() {
                    @Override
                    public String toString() {
                        return "ResourceWait-" + name + "-" +
                                System.currentTimeMillis();
                    }
                };
            }

            public void acquire() {
                System.out.println(Thread.currentThread().getName() +
                        " 等待资源: " + name);
                LockSupport.park(waitBlocker);
                System.out.println(Thread.currentThread().getName() +
                        " 获取资源: " + name);
            }

            public void release() {
                System.out.println("释放资源: " + name);
            }

            public Object getBlocker() {
                return waitBlocker;
            }
        }

        Resource dbConnection = new Resource("DB-Connection");
        Resource fileLock = new Resource("File-Lock");

        Thread t1 = new Thread(() -> dbConnection.acquire(), "Thread-1");
        Thread t2 = new Thread(() -> fileLock.acquire(), "Thread-2");

        t1.start();
        t2.start();

        // 模拟监控系统获取阻塞信息
        Thread.sleep(100);
        System.out.println("\n=== 监控系统 ===");
        System.out.println(t1.getName() + " 阻塞对象: " +
                LockSupport.getBlocker(t1));
        System.out.println(t2.getName() + " 阻塞对象: " +
                LockSupport.getBlocker(t2));

        // 唤醒线程
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);

        t1.join();
        t2.join();
    }

    // null 阻塞对象的处理
    public static void nullBlockerExample() {
        Thread thread = new Thread(() -> {
            // 使用 null 作为阻塞对象
            LockSupport.park(null);
            System.out.println("线程被唤醒");
        });

        thread.start();

        try {
            Thread.sleep(50);

            // 获取阻塞对象
            Object blocker = LockSupport.getBlocker(thread);
            System.out.println("null 阻塞对象: " + blocker);

            LockSupport.unpark(thread);
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 1. 基本阻塞对象示例 ===");
        basicParkWithBlocker();

        System.out.println("\n=== 2. 多个阻塞对象示例 ===");
        multipleBlockersExample();

        System.out.println("\n=== 3. 调试应用示例 ===");
        debuggingExample();

        System.out.println("\n=== 4. null 阻塞对象处理 ===");
        nullBlockerExample();
    }
}
