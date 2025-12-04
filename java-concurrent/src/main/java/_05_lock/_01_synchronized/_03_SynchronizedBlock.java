package _05_lock._01_synchronized;

public class _03_SynchronizedBlock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private int value1 = 0;
    private int value2 = 0;

    // 同步代码块，可以指定任意对象作为锁
    public void method1() {
        // 非同步代码
        System.out.println("Non-synchronized part");

        // 同步代码块，使用lock1作为锁
        synchronized (lock1) {
            value1++;
            System.out.println("Value1: " + value1);
        }

        // 另一个同步块，使用不同的锁，可以并行执行
        synchronized (lock2) {
            value2++;
            System.out.println("Value2: " + value2);
        }
    }

    // 使用类锁的同步代码块
    public void method2() {
        synchronized (_03_SynchronizedBlock.class) {
            System.out.println("Synchronized on class level");
        }
    }

    // 使用实例锁的同步代码块
    public void method3() {
        synchronized (this) {
            System.out.println("Synchronized on this instance");
        }
    }
}
