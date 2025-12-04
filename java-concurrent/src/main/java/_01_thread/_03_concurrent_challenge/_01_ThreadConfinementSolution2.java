package _01_thread._03_concurrent_challenge;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 方案2：ThreadLocal
 * @author qy
 */
public class _01_ThreadConfinementSolution2 {

    // 每个线程有自己的SimpleDateFormat实例
    private static final ThreadLocal<SimpleDateFormat> dateFormat =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public String formatDate(Date date) {
        return dateFormat.get().format(date);  // 线程安全
    }
}
