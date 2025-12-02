package _01_thread._01_thread_method;

/**
 * 启动线程，使其进入RUNNABLE状态
 * 原理：启动一个新线程，调用run()方法
 * 注意：不能多次调用，否则抛出IllegalThreadStateException
 * @author qy
 */
public class _01_ThreadStart {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("线程ID: " + Thread.currentThread().getId());
            System.out.println("线程名称: " + Thread.currentThread().getName());
        }, "自定义线程");

        // 正确：启动线程
        thread.start(); // 输出：线程ID: 12, 线程名称: 自定义线程

        // 错误：再次调用会抛出异常
        try {
            thread.start(); // IllegalThreadStateException
        } catch (IllegalThreadStateException e) {
            System.out.println("线程不能重复启动: " + e.getMessage());
        }
    }
}
