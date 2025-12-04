package _01_thread._03_concurrent_challenge;

import java.util.ArrayList;
import java.util.List;
/**
 * 方案3：实例封闭
 * @author qy
 */
public class _01_ThreadConfinementSolution3 {
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
