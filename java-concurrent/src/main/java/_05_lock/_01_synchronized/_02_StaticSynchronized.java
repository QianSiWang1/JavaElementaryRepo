package _05_lock._01_synchronized;

/**
 * @author qy
 */
public class _02_StaticSynchronized {
    private static int counter = 0;

    // 同步静态方法，锁是当前类的Class对象
    public static synchronized void staticMethod() {
        counter++;
        System.out.println("Static method counter: " + counter);
    }

    // 所有静态同步方法共享同一把锁（类锁）
    public static synchronized void anotherStaticMethod() {
        counter--;
        System.out.println("Another static method counter: " + counter);
    }
}
