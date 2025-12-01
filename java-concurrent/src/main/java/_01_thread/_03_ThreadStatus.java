package _01_thread;

public class _03_ThreadStatus {
    public static void main(String[] args) throws Exception {
        // 1. NEW 状态
        Thread thread = new Thread(() -> {
            // 线程执行逻辑
            synchronized (_03_ThreadStatus.class) {
                try {
                    Thread.sleep(1000);        // TIMED_WAITING
                    _03_ThreadStatus.class.wait(); // WAITING
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        System.out.println("创建后: " + thread.getState()); // NEW

        // 2. RUNNABLE 状态
        thread.start();
        Thread.sleep(10);
        System.out.println("启动后: " + thread.getState()); // RUNNABLE

        // 3. BLOCKED 状态
        synchronized (_03_ThreadStatus.class) {
            Thread.sleep(100);
            System.out.println("获取锁时: " + thread.getState()); // BLOCKED
        }

        // 4. TIMED_WAITING 状态
        Thread.sleep(100);
        System.out.println("sleep时: " + thread.getState()); // TIMED_WAITING

        // 5. WAITING 状态
        synchronized (_03_ThreadStatus.class) {
            _03_ThreadStatus.class.notify();
        }
        Thread.sleep(100);
        System.out.println("wait时: " + thread.getState()); // WAITING

        // 6. TERMINATED 状态
        thread.join();
        System.out.println("结束后: " + thread.getState()); // TERMINATED
    }
}
