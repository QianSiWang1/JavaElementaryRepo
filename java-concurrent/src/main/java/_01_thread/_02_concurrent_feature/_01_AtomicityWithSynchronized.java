package _01_thread._02_concurrent_feature;

/**
 * @author qy
 */
public class _01_AtomicityWithSynchronized {
    private int count = 0;

    /**
     * synchronized保证原子性的原理：
     * 1. 通过monitorenter/monitorexit字节码指令
     * 2. 同一时刻只有一个线程能执行同步块
     * 3. 锁的释放会将工作内存刷新到主内存
     */
    public synchronized void increment() {
        count++;  // 现在这是原子操作
    }

    /**
     * 同步代码块 - 更细粒度的控制
     */
    private final Object lock = new Object();

    public void incrementWithBlock() {
        synchronized (lock) {
            count++;
        }
    }
}
