package _01_thread._03_concurrent_challenge._03_live_lock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 消息处理中的活锁
 * @author qy
 */
public class _02_MessageProcessorLivelock {
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void process() {
        while (true) {
            String msg = queue.poll();
            if (msg != null) {
                try {
                    handleMessage(msg);
                } catch (Exception e) {
                    // 处理失败，重新入队
                    queue.offer(msg);
                    Thread.yield();  // 让其他线程有机会
                }
            }
        }
    }

    // 如果消息总是处理失败，会不断重试，形成活锁

    private void handleMessage(String msg) {

    }
}
