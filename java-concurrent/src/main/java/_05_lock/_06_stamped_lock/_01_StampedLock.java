package _05_lock._06_stamped_lock;

import java.util.concurrent.locks.StampedLock;

/**
 * @Author qy
 * @Date 2025/12/6
 */
public class _01_StampedLock {
    private double x, y;
    private final StampedLock lock = new StampedLock();

    // 写锁示例
    public void move(double deltaX, double deltaY) {
        long stamp = lock.writeLock();  // 获取写锁
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            lock.unlockWrite(stamp);  // 释放写锁
        }
    }

    // 读锁示例
    public double distanceFromOrigin() {
        long stamp = lock.readLock();  // 获取读锁
        try {
            return Math.sqrt(x * x + y * y);
        } finally {
            lock.unlockRead(stamp);  // 释放读锁
        }
    }
}
