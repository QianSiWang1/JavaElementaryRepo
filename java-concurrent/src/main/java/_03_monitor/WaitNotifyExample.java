package _03_monitor;

public class WaitNotifyExample {
    final static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "执行...");
                try {
                    obj.wait(); // 让线程在obj上一直等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行其他代码");
            }
        }, "t1");
        t1.start();
        Thread.sleep(1000); // 确保t1先运行
        synchronized (obj) {
            System.out.println("通知t1继续执行");
            obj.notify(); // 唤醒t1线程
        }
    }
}
