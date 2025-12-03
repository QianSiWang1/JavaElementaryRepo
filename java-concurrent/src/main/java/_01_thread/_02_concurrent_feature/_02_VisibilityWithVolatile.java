package _01_thread._02_concurrent_feature;

/**
 * @author qy
 */
public class _02_VisibilityWithVolatile {
    /**
     * volatile保证可见性的原理：
     * 1. 写操作：在写操作后插入StoreStore和StoreLoad屏障
     * 2. 读操作：在读操作前插入LoadLoad和LoadStore屏障
     * 3. 强制缓存失效：写操作使其他CPU的缓存行失效
     */
    private volatile boolean flag = true;

    public void volatileExample() {
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(100);
                flag = false;  // volatile写
                System.out.println("Writer: flag set to false");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread reader = new Thread(() -> {
            while (flag) {  // volatile读
                // 循环
            }
            System.out.println("Reader: detected flag change");
        });

        reader.start();
        writer.start();
    }
}
