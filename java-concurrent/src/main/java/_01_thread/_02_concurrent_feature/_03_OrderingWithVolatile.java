package _01_thread._02_concurrent_feature;

/**
 * @author qy
 */
public class _03_OrderingWithVolatile {
    private int a = 0;
    private int b = 0;
    private volatile boolean ready = false;

    public void writer() {
        // 普通写
        a = 1;
        // 普通写
        b = 2;
        // volatile写 - 插入StoreStore和StoreLoad屏障
        ready = true;
    }

    public void reader() {
        // volatile读 - 插入LoadLoad和LoadStore屏障
        if (ready) {
            // 保证能看到a=1和b=2的结果
            System.out.println("a=" + a + ", b=" + b);
        }
    }
}
