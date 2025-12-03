package _01_thread._02_concurrent_feature;

/**
 * @author qy
 */
public class _02_VisibilityWithSynchronized {
    private boolean flag = true;

    /**
     * synchronized保证可见性的原理：
     * 1. 进入同步块：清空工作内存，从主内存重新加载
     * 2. 退出同步块：将工作内存刷新到主内存
     */
    public synchronized void setFlag(boolean value) {
        this.flag = value;
    }

    public synchronized boolean getFlag() {
        return this.flag;
    }

    public void synchronizedExample() {
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(100);
                setFlag(false);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread reader = new Thread(() -> {
            while (getFlag()) {
                // 每次读取都会进入同步块，保证看到最新值
            }
        });

        reader.start();
        writer.start();
    }
}
