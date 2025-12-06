package _05_lock._04_reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qy
 */
public class _01_ReentrantLockBestPractice {
    private final ReentrantLock lock = new ReentrantLock();

    public void safeMethod() {
        // 尝试获取锁，避免死锁
        if (!lock.tryLock()) {
            // 获取锁失败的处理逻辑
            return;
        }

        try {
            // 临界区代码
        } finally {
            lock.unlock();
        }
    }

    public void interruptibleMethod() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            // 长时间操作
            while (!Thread.currentThread().isInterrupted()) {
                // 处理任务
            }
        } finally {
            lock.unlock();
        }
    }
}
