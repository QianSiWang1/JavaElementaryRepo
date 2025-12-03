package _01_thread._03_concurrent_challenge._04_starvation;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁饥饿
 * @author qy
 */
public class _02_LockStarvation {
    // 默认非公平锁
    private final ReentrantLock lock = new ReentrantLock();

    public void accessResource() {
        lock.lock();
        try {
            // 长时间持有锁
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    // 如果很多线程竞争，某些线程可能永远获取不到锁
}
