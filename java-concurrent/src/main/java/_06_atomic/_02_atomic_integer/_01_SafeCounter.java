package _06_atomic._02_atomic_integer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author qy
 * @Date 2025/12/6
 */
public class _01_SafeCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
