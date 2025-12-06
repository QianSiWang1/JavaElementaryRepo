package _06_atomic._02_atomic_integer;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author qy
 * @Date 2025/12/6
 */
public class _02_ABAProblem {
    public static void main(String[] args) {
        // 线程1：准备将值从A改为C
        // 线程2：将值从A改为B，再改回A
        // 线程1的CAS操作会成功，但期间已经发生过变化

        AtomicInteger atomicInt = new AtomicInteger(1);

        // 线程1
        boolean success = atomicInt.compareAndSet(1, 3);

        // 线程2
        atomicInt.compareAndSet(1, 2);
        atomicInt.compareAndSet(2, 1);  // ABA问题


        AtomicStampedReference<Integer> stampedRef =
                new AtomicStampedReference<>(1, 0);

        // 获取当前值和版本戳
        int[] stampHolder = new int[1];
        int currentValue = stampedRef.get(stampHolder);
        int currentStamp = stampHolder[0];

        // 带版本戳的CAS操作
        stampedRef.compareAndSet(currentValue, 2, currentStamp, currentStamp + 1);
    }
}
