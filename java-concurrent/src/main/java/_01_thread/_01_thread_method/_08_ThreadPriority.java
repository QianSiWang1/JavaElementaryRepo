package _01_thread._01_thread_method;

/**
 * 线程优先级（1-10）：
 * 1. 只是提示，操作系统可能忽略
 * 2. 默认优先级是5（NORM_PRIORITY）
 *
 * @author qy
 */
public class _08_ThreadPriority {


    public static void priorityDemo() {
        Thread lowPriority = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("低优先级线程执行");
                Thread.yield();
            }
        });

        Thread highPriority = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("高优先级线程执行");
                Thread.yield();
            }
        });

        // 设置优先级
        // 1
        lowPriority.setPriority(Thread.MIN_PRIORITY);
        // 10
        highPriority.setPriority(Thread.MAX_PRIORITY);

        System.out.println("低优先级: " + lowPriority.getPriority());
        System.out.println("高优先级: " + highPriority.getPriority());

        // 注意：优先级不一定保证执行顺序
        lowPriority.start();
        highPriority.start();
    }

    /**
     * 优先级继承
     */
    public static void priorityInheritance() {
        Thread parent = new Thread(() -> {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

            Thread child = new Thread(() -> {
                System.out.println("子线程优先级: " +
                        Thread.currentThread().getPriority()); // 继承父线程的优先级
            });

            child.start();
        });

        parent.start();
    }

}
