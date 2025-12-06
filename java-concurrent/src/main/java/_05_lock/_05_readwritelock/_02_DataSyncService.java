package _05_lock._05_readwritelock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Author qy
 * @Date 2025/12/6
 */
public class _02_DataSyncService {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final List<String> dataList = new ArrayList<>();

    // 批量读取
    public List<String> batchRead() {
        rwLock.readLock().lock();
        try {
            // 创建数据的副本，避免长时间持有读锁
            return new ArrayList<>(dataList);
        } finally {
            rwLock.readLock().unlock();
        }
    }

    // 批量更新
    public void batchUpdate(List<String> newData) {
        rwLock.writeLock().lock();
        try {
            dataList.clear();
            dataList.addAll(newData);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    // 条件更新
    public boolean updateIf(Predicate<List<String>> condition,
                            Consumer<List<String>> updateAction) {
        rwLock.writeLock().lock();
        try {
            if (condition.test(dataList)) {
                updateAction.accept(dataList);
                return true;
            }
            return false;
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}
