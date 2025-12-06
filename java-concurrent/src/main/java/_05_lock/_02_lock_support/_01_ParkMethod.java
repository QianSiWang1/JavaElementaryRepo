package _05_lock._02_lock_support;

import java.util.concurrent.locks.LockSupport;

/**
 * park() 方法详解
 *
 * 功能：阻塞当前线程，直到以下情况之一发生：
 * 1. 其他线程调用 unpark() 唤醒该线程
 * 2. 线程被中断
 * 3. 发生虚假唤醒
 *
 * 特点：
 * - 不需要获取任何锁
 * - 基于许可机制（每个线程有一个许可，初始为0）
 * - 可以响应中断
 * - 可能发生虚假唤醒
 * @author qy
 */
public class _01_ParkMethod {

    // 基本使用示例
    public static void basicParkExample() throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("Worker: 开始执行任务");
            System.out.println("Worker: 即将调用 park() 阻塞自己");

            // 阻塞当前线程
            LockSupport.park();

            System.out.println("Worker: 被唤醒，继续执行任务");

            // 检查中断状态
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Worker: 检测到中断状态");
            }
        }, "Worker-Thread");

        worker.start();

        // 主线程等待1秒后唤醒工作线程
        Thread.sleep(1000);
        System.out.println("Main: 唤醒工作线程");
        LockSupport.unpark(worker);

        worker.join();
    }

    // park() 的许可机制演示
    public static void permitMechanismDemo() {
        Thread thread = new Thread(() -> {
            System.out.println("1. 线程开始执行");

            // 第一次 park，没有许可，会阻塞
            System.out.println("2. 第一次调用 park()");
            LockSupport.park();
            System.out.println("3. 第一次被唤醒");

            // 再次 park，需要新的许可
            System.out.println("4. 第二次调用 park()");
            LockSupport.park();
            System.out.println("5. 第二次被唤醒");

            // 第三次 park
            System.out.println("6. 第三次调用 park()");
            LockSupport.park();
            System.out.println("7. 第三次被唤醒 - 程序结束");
        });

        thread.start();

        // 主线程控制唤醒
        try {
            Thread.sleep(100);

            // 第一次唤醒
            System.out.println("Main: 第一次 unpark");
            LockSupport.unpark(thread);

            Thread.sleep(100);

            // 第二次唤醒
            System.out.println("Main: 第二次 unpark");
            LockSupport.unpark(thread);

            Thread.sleep(100);

            // 第三次唤醒
            System.out.println("Main: 第三次 unpark");
            LockSupport.unpark(thread);

            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // park() 与中断的交互
    public static void parkInterruptExample() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始，即将 park()");

            // park() 会响应中断
            LockSupport.park();

            System.out.println("线程从 park() 返回");
            System.out.println("中断状态: " + Thread.currentThread().isInterrupted());

            // 清除中断状态
            boolean wasInterrupted = Thread.interrupted();
            System.out.println("清除中断状态，之前的状态: " + wasInterrupted);

            // 再次 park
            System.out.println("再次 park()");
            LockSupport.park();
            System.out.println("再次被唤醒");
        });

        thread.start();

        // 给线程一点时间进入 park 状态
        Thread.sleep(50);

        // 中断线程
        System.out.println("主线程中断工作线程");
        thread.interrupt();

        // 再给一点时间让线程处理中断
        Thread.sleep(100);

        // 唤醒线程（因为中断后线程可能已经不在 park 状态）
        LockSupport.unpark(thread);

        thread.join();
    }

    // park() 的虚假唤醒
    public static void spuriousWakeupExample() {
        Thread thread = new Thread(() -> {
            int wakeupCount = 0;

            while (wakeupCount < 100) {
                System.out.println("线程 park()，等待被唤醒");
                LockSupport.park();

                // park() 可能在没有 unpark 或中断的情况下返回
                wakeupCount++;
                System.out.println("park() 返回，第 " + wakeupCount + " 次唤醒");

                try {
                    Thread.sleep(100); // 避免忙等待
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            System.out.println("线程结束，总共唤醒 " + wakeupCount + " 次");
        });

        thread.start();

        try {
            // 不调用 unpark，观察虚假唤醒
            Thread.sleep(5000);
            thread.interrupt();
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 1. 基本 park() 示例 ===");
        basicParkExample();

        System.out.println("\n=== 2. 许可机制演示 ===");
        permitMechanismDemo();

        System.out.println("\n=== 3. park() 与中断交互 ===");
        parkInterruptExample();

        System.out.println("\n=== 4. 虚假唤醒示例 ===");
        spuriousWakeupExample();
    }
}