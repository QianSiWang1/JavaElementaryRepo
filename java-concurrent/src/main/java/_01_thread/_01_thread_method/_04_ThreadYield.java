package _01_thread._01_thread_method;
/**
 * yield() 方法详解：
 * 1. 提示调度器当前线程愿意让出CPU
 * 2. 调度器可以忽略此提示
 * 3. 适用于需要"礼貌"地让出CPU的场景
 * @author qy
 */
public class _04_ThreadYield {
    public static void main(String[] args) {
        basicYield();
    }

    /**
     * 基本用法：让出CPU给相同优先级的线程
     */
    public static void basicYield() {
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("生产者: 生产第" + i + "个产品");
                Thread.yield(); // 生产完后让出CPU
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("消费者: 消费第" + i + "个产品");
                // 消费完后让出CPU
                Thread.yield();
            }
        });

        producer.start();
        consumer.start();
    }

    /**
     * yield() 与 sleep(0) 的区别
     */
    public static void yieldVsSleep() {
        // yield() 只是提示，可能立即重新被调度
        // sleep(0) 在Linux上会让出CPU，在Windows上可能不会

        System.out.println("=== 使用yield() ===");
        for (int i = 0; i < 3; i++) {
            System.out.println("执行 " + i);
            Thread.yield();
        }

        System.out.println("=== 使用sleep(0) ===");
        for (int i = 0; i < 3; i++) {
            System.out.println("执行 " + i);
            try {
                // 可能让出CPU
                Thread.sleep(0);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * yield() 的适用场景 - 自旋锁优化
     */
    public static class SpinLockWithYield {
        private volatile boolean locked = false;

        public void lock() {
            while (!tryLock()) {
                // 获取锁失败时让出CPU
                Thread.yield();
            }
        }

        public boolean tryLock() {
            if (!locked) {
                locked = true;
                return true;
            }
            return false;
        }

        public void unlock() {
            locked = false;
        }
    }

}
