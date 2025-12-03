package _01_thread._03_concurrent_challenge;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author qy
 */
public class _01_ThreadConfinementSolutions {
    /**
     * 方案1：栈封闭
     */
    public void stackConfinement() {
        // 局部变量 - 每个线程有自己的副本
        int localCounter = 0;
        for (int i = 0; i < 100; i++) {
            localCounter++;  // 线程安全，因为每个线程有自己的栈
        }
    }

    /**
     * 方案2：ThreadLocal
     */
    public class ThreadLocalExample {
        // 每个线程有自己的SimpleDateFormat实例
        private static final ThreadLocal<SimpleDateFormat> dateFormat =
                ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

        public String formatDate(Date date) {
            return dateFormat.get().format(date);  // 线程安全
        }
    }

    /**
     * 方案3：实例封闭
     */
    public class InstanceConfinement {
        // 私有变量，不暴露给外部
        private final List<String> internalList = new ArrayList<>();

        // 同步访问方法
        public synchronized void add(String item) {
            internalList.add(item);
        }

        public synchronized boolean contains(String item) {
            return internalList.contains(item);
        }
    }
}
