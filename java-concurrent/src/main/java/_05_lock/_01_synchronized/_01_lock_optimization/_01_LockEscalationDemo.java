package _05_lock._01_synchronized._01_lock_optimization;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.util.logging.Logger;

/**
 * @author qy
 */

public class _01_LockEscalationDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
        //HotSpot 虚拟机在启动后有个 4s 的延迟才会对每个新建的对象开启偏向锁模式
        Thread.sleep(4000);
        Object obj = new Object();
        // 思考： 如果对象调用了hashCode,还会开启偏向锁模式吗
        obj.hashCode();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        //log.debug(ClassLayout.parseInstance(obj).toPrintable());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始执行。。。\n"
                        + ClassLayout.parseInstance(obj).toPrintable());
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + "获取锁执行中。。。\n"
                            + ClassLayout.parseInstance(obj).toPrintable());
                }
                System.out.println(Thread.currentThread().getName() + "释放锁。。。\n"
                        + ClassLayout.parseInstance(obj).toPrintable());
            }
        }, "thread1").start();

        Thread.sleep(5000);
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
