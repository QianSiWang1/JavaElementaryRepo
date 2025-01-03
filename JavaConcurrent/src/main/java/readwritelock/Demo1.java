package readwritelock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo1 {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        List<Object> objects = Collections.synchronizedList(new ArrayList<>());
    }
}
