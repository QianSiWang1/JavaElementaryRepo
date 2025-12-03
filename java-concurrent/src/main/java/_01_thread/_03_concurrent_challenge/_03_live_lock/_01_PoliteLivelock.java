package _01_thread._03_concurrent_challenge._03_live_lock;

/**
 * 礼貌导致的活锁
 * @author qy
 */
public class _01_PoliteLivelock {
    class Person {
        private boolean moving = false;

        public void pass(Person other) {
            while (moving) {
                Thread.yield();  // 礼貌地让路
            }

            moving = true;
            Thread.yield();  // 让其他线程有机会执行

            // 如果两个线程同时执行到这里，都会看到对方在移动
            // 都会退让，然后重试，形成活锁
            moving = false;
        }
    }
}
