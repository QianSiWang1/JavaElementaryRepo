package _01_thread._01_thread_method;

/**
 * 中断机制详解：
 * 1. interrupt(): 设置中断标志，如果线程在阻塞状态会抛出InterruptedException
 * 2. isInterrupted(): 检查中断标志，不清除
 * 3. interrupted(): 检查中断标志并清除
 * @author qy
 */
public class _06_ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        interruptSleepingThread();
    }


    /**
     * 中断阻塞状态的线程
     */
    public static void interruptSleepingThread() throws InterruptedException {
        Thread sleeper = new Thread(() -> {
            System.out.println("线程准备睡眠");
            try {
                Thread.sleep(5000);
                System.out.println("睡眠完成"); // 如果被中断，这行不会执行
            } catch (InterruptedException e) {
                System.out.println("线程被中断，中断状态: " +
                        Thread.currentThread().isInterrupted()); // false
                // 恢复中断状态
                Thread.currentThread().interrupt();
                System.out.println("恢复中断状态后: " +
                        Thread.currentThread().isInterrupted()); // true
            }
        });

        sleeper.start();
        Thread.sleep(1000); // 让sleeper进入睡眠
        System.out.println("主线程中断sleeper");
        sleeper.interrupt();
        sleeper.join();
    }

    /**
     * isInterrupted() vs interrupted()
     */
    public static void compareInterruptMethods() {
        Thread thread = new Thread(() -> {
            // 设置中断状态
            Thread.currentThread().interrupt();

            // isInterrupted() - 不清除状态
            System.out.println("第一次检查: " + Thread.currentThread().isInterrupted()); // true
            System.out.println("第二次检查: " + Thread.currentThread().isInterrupted()); // true

            // interrupted() - 清除状态
            System.out.println("interrupted()检查: " + Thread.interrupted()); // true
            System.out.println("清除后再次检查: " + Thread.currentThread().isInterrupted()); // false
        });

        thread.start();
    }

    /**
     * 正确的中断处理模式
     */
    public static class ProperInterruption {
        public static void main(String[] args) throws InterruptedException {
            Thread worker = new Thread(() -> {
                // 模式1: 在循环开始前检查
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        // 执行工作
                        doWork();
                    } catch (InterruptedException e) {
                        // 捕获到中断异常，有两种选择:

                        // 选择1: 重新设置中断状态并退出
                        Thread.currentThread().interrupt();
                        System.out.println("收到中断请求，准备退出");
                        break;

                        // 选择2: 忽略中断，继续工作（不推荐）
                        // System.out.println("忽略中断，继续工作");
                        // continue;
                    }
                }
                System.out.println("线程优雅退出");
            });

            worker.start();
            Thread.sleep(100);
            worker.interrupt();
            worker.join();
        }

        private static void doWork() throws InterruptedException {
            // 模拟工作，可能会阻塞
            Thread.sleep(10);
        }
    }

}
