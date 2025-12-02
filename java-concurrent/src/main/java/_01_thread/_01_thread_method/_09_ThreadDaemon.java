package _01_thread._01_thread_method;

import java.io.FileWriter;

/**
 * 守护线程：
 * 1. 不会阻止JVM退出
 * 2. 所有非守护线程结束时，守护线程会自动终止
 * @author qy
 */
public class _09_ThreadDaemon {
    public static void main(String[] args) {
        daemonThreadDemo();
    }


    public static void daemonThreadDemo() {
        // 创建守护线程
        Thread daemonThread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("守护线程运行中...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        // 必须在start()之前设置
        daemonThread.setDaemon(true);

        // 创建非守护线程
        Thread userThread = new Thread(() -> {
            try {
                System.out.println("用户线程开始工作...");
                Thread.sleep(3000);
                System.out.println("用户线程工作完成");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        daemonThread.start();
        userThread.start();

        // 用户线程结束后，即使守护线程还在运行，JVM也会退出
    }

    /**
     * 守护线程的注意事项
     */
    public static void daemonPitfalls() {
        Thread daemon = new Thread(() -> {
            try {
                // 守护线程中创建的资源可能无法正确清理
                FileWriter writer = new FileWriter("daemon.log");
                writer.write("守护线程日志\n");

                // 守护线程突然终止，可能不会执行finally块
                while (true) {
                    Thread.sleep(1000);
                    writer.write("心跳\n");
                    writer.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("守护线程清理"); // 可能不会执行
            }
        });

        daemon.setDaemon(true);
        daemon.start();

        // 主线程快速退出
        System.out.println("主线程退出");
    }

}
