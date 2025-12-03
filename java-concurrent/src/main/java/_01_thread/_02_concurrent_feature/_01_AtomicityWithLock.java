package _01_thread._02_concurrent_feature;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qy
 */
public class _01_AtomicityWithLock {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;  // 原子操作
        } finally {
            lock.unlock();  // 必须放在finally中
        }
    }
}
