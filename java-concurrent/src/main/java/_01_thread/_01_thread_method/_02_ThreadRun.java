package _01_thread._01_thread_method;

/**
 * @author qy
 */
public class _02_ThreadRun {
    /**
     * run() vs start() 的区别：
     * 1. start()会创建新线程执行run()
     * 2. 直接调用run()会在当前线程执行，不会创建新线程
     */
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("当前线程: " + Thread.currentThread().getName());
        });

        System.out.println("=== 测试直接调用run() ===");
        thread.run();  // 输出：当前线程: main（在主线程执行）

        System.out.println("=== 测试调用start() ===");
        thread.start(); // 输出：当前线程: Thread-0（在新线程执行）
    }

}
