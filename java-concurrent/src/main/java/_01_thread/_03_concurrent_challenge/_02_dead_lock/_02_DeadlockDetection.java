package _01_thread._03_concurrent_challenge._02_dead_lock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author qy
 */
public class _02_DeadlockDetection {
    /**
     * 使用jstack检测死锁
     */
    public static void detectWithJStack() throws Exception {
        _01_DeadlockExamples example = new _01_DeadlockExamples();

        Thread t1 = new Thread(example::method1, "Thread-1");
        Thread t2 = new Thread(example::method2, "Thread-2");

        t1.start();
        t2.start();

        Thread.sleep(2000);

        // 手动执行：jstack <pid> 查看死锁信息
    }

    /**
     * 程序化死锁检测
     */
    public static void programmaticDetection() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // 定期检查死锁
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
            if (deadlockedThreads != null && deadlockedThreads.length > 0) {
                System.err.println("检测到死锁!");
                ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(deadlockedThreads);
                for (ThreadInfo threadInfo : threadInfos) {
                    System.err.println("死锁线程: " + threadInfo.getThreadName());
                    System.err.println("等待锁: " + threadInfo.getLockName());
                    System.err.println("被锁持有者: " + threadInfo.getLockOwnerName());
                }
                // 可以发送警报或采取恢复措施
            }
        }, 5, 5, TimeUnit.SECONDS);
    }
}
