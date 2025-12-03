package _01_thread._03_concurrent_challenge._04_starvation;

/**
 * 线程优先级导致的饥饿
 * @author qy
 */
public class _01_PriorityStarvation {
    public void demonstrate() {
        Thread highPriority = new Thread(() -> {
            while (true) {
                // 占用CPU
            }
        });
        highPriority.setPriority(Thread.MAX_PRIORITY);

        Thread lowPriority = new Thread(() -> {
            // 可能永远无法执行
            System.out.println("低优先级线程终于执行了");
        });
        lowPriority.setPriority(Thread.MIN_PRIORITY);

        highPriority.start();
        lowPriority.start();
    }
}
