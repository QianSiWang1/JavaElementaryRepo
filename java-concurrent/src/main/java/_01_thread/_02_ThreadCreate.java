package _01_thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class _02_ThreadCreate {
    @Test
    public void threadCreate_01() {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
    }

    @Test
    public void threadCreate_02() {
        RunnableImpl run = new RunnableImpl();
        Thread thread = new Thread(run, "Runnable");
        thread.start();
    }

    @Test
    public void threadCreate_03() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask, "FutureTask").start();
        int b = 0;
        int a = 100;
        while (!futureTask.isDone()) {
            b = futureTask.get();
        }
        System.out.println("Result is : " + (a + b));
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run: " + Thread.currentThread().getName() + "  " + i);
        }

    }
}

class RunnableImpl implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run: " + Thread.currentThread().getName() + "  " + i);
        }
    }

}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable come in");
        return 1024;
    }
}



