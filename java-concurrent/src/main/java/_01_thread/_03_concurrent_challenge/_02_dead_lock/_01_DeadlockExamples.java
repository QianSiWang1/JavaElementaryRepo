package _01_thread._03_concurrent_challenge._02_dead_lock;

public class _01_DeadlockExamples {
    /**
     * 经典死锁示例：资源顺序获取不一致
     */
    private final Object lockA = new Object();
    private final Object lockB = new Object();

    public void method1() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " 持有 lockA");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " 持有 lockB");
            }
        }
    }

    public void method2() {
        synchronized (lockB) {  // 相反的顺序！
            System.out.println(Thread.currentThread().getName() + " 持有 lockB");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + " 持有 lockA");
            }
        }
    }

    /**
     * 死锁发生场景：
     * 线程1：获取lockA → 尝试获取lockB
     * 线程2：获取lockB → 尝试获取lockA
     * 结果：互相等待，死锁！
     */

}
