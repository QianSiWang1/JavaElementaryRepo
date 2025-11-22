package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程打印1-10，要求奇数线程打印奇数，偶数线程打印偶数，交替打印。
 */
public class OddEvenPrinter {
    private static final ReentrantLock lock = new ReentrantLock();
    static Condition odd = lock.newCondition();
    static Condition even = lock.newCondition();
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                lock.lock();
                try {
                    if (i % 2 == 1){
                        System.out.println(Thread.currentThread().getName()+"打印"+i);
                        odd.await();
                    }else {
                        even.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "奇数线程").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                lock.lock();
                try {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName()+"打印"+i);
                        even.await();
                    }else {
                        odd.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "偶数线程").start();
    }
}
