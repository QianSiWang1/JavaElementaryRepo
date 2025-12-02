package _01_thread._01_thread_method;

/**
 * 线程状态枚举：
 * NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED
 *
 * @author qy
 */
public class _10_ThreadState {
    public static void main(String[] args) throws InterruptedException {
        monitorThreadStates();
    }


    public static void monitorThreadStates() throws InterruptedException {
        Object lock = new Object();

        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("线程进入WAITING状态");
                    lock.wait();
                    System.out.println("线程被唤醒");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // NEW状态
        System.out.println("创建后: " + thread.getState());

        thread.start();
        Thread.sleep(10);

        // RUNNABLE状态
        System.out.println("启动后: " + thread.getState());

        // 让线程进入WAITING状态
        Thread.sleep(10);
        System.out.println("wait后: " + thread.getState());

        // 唤醒线程
        synchronized (lock) {
            lock.notify();
        }

        Thread.sleep(10);
        // RUNNABLE
        System.out.println("唤醒后: " + thread.getState());

        // 等待线程结束
        thread.join();
        // TERMINATED
        System.out.println("结束后: " + thread.getState());
    }

}
