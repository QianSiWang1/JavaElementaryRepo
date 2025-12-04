package _05_lock._01_synchronized;

/**
 * @author qy
 */
public class _01_SynchronizedMethod {
    // 同步实例方法，锁是当前实例对象(this)
    public synchronized void instanceMethod() {
        // 临界区代码
        System.out.println("Instance method synchronized on: " + this);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 同一个实例的不同同步方法会互斥
    public synchronized void anotherInstanceMethod() {
        System.out.println("Another instance method");
    }
}
