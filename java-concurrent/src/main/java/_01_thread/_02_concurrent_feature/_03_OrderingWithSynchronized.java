package _01_thread._02_concurrent_feature;

/**
 * @author qy
 */
public class _03_OrderingWithSynchronized {
    private int a = 0;
    private int b = 0;

    public synchronized void writer() {
        a = 1;
        b = 2;
    }

    public synchronized void reader() {
        // 能看到writer()中的所有修改
        System.out.println("a=" + a + ", b=" + b);
    }
}
