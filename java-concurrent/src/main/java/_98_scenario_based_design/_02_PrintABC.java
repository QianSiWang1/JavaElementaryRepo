package _98_scenario_based_design;

import java.util.concurrent.Semaphore;

/**
 * 三个线程 打印 ABC，循环执行 10 次，轮流 执行
 */
public class _02_PrintABC {
    public static void main(String[] args) {
        _02_PrintABC printABC = new _02_PrintABC(10);
        new Thread(printABC::printA, "Thread-A").start();
        new Thread(printABC::printB, "Thread-B").start();
        new Thread(printABC::printC,"Thread-C").start();
    }
    private final int max;
    // 从线程 A 开始执行
    private final Semaphore semaphoreA = new Semaphore(1);
    private final Semaphore semaphoreB = new Semaphore(0);
    private final Semaphore semaphoreC = new Semaphore(0);

    public _02_PrintABC(int max) {
        this.max = max;
    }

    public void printA() {
        print("A", semaphoreA, semaphoreB);
    }

    public void printB() {
        print("B", semaphoreB, semaphoreC);
    }

    public void printC() {
        print("C", semaphoreC, semaphoreA);
    }

    private void print(String alphabet, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        for (int i = 1; i <= max; i++) {
            try {
                currentSemaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " : " + alphabet);
                // 传递信号给下一个线程
                nextSemaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

}
