package _01_thread._02_concurrent_feature;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qy
 */
public class _01_AtomicityWithAtomic {
    private AtomicInteger count = new AtomicInteger(0);

    /**
     * CAS（Compare-And-Swap）原理：
     * 1. 读取当前值
     * 2. 计算新值
     * 3. 如果当前值等于预期值，则更新为新值
     * 4. 否则重试或失败
     */
    public void increment() {
        // 底层实现：unsafe.compareAndSwapInt
        count.incrementAndGet();  // 原子操作
    }

    /**
     * CAS的ABA问题
     */
    public void abaProblem() {
        // 初始值：A
        count.set(10);

        // 线程1：A -> B -> A
        // 线程2：看到A，认为没有变化
        // 但实际上已经变化过了！
    }
}
