package _01_thread._03_concurrent_challenge;

//import jdk.internal.org.jline.utils.ShutdownHooks;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author qy
 */
public class _01_SynchronizationStrategies {
    /**
     * 策略1：对象内部锁
     */
    public static class IntrinsicLock {
        private final Object lock = new Object();
        private int counter = 0;

        public void increment() {
            synchronized (lock) {
                counter++;
            }
        }

        public int get() {
            synchronized (lock) {
                return counter;
            }
        }
    }

    /**
     * 策略2：并发集合
     */
    public static class ConcurrentCollections {
        // 读多写少
        private final CopyOnWriteArrayList<String> eventListeners =
                new CopyOnWriteArrayList<>();

        // 高并发读写
        private final ConcurrentHashMap<String, Object> cache =
                new ConcurrentHashMap<>();

        // 线程安全的队列
//        private final BlockingQueue<ShutdownHooks.Task> taskQueue =
//                new LinkedBlockingQueue<>();
    }

    /**
     * 策略3：原子变量
     */
    public static class AtomicVariables {
        private final AtomicInteger counter = new AtomicInteger(0);
        private final AtomicReference<String> latestValue =
                new AtomicReference<>("initial");

        public void update() {
            // CAS操作，无锁
            counter.incrementAndGet();

            // 原子更新
            latestValue.updateAndGet(old -> old + " updated");
        }
    }
}
