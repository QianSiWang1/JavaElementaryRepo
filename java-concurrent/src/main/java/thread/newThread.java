package thread;

import java.util.concurrent.*;

public class newThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("hello world Thread 1"));
        t1.start();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world Runnable Thread2");
            }
        };
        new Thread(r1).start();
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 0;
            }
        });
        Thread thread3 = new Thread(futureTask,"futureTask");
        thread3.start();


        ExecutorService threadPool = new ThreadPoolExecutor(3, 5, 1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        Future<Integer> submit = threadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 1;
            }
        });
        threadPool.execute(r1);
        try {
            Integer i = futureTask.get();
            System.out.println("futureTask value is " + i);
            Integer i1 = submit.get();
            System.out.println("submit value is " + i1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        }
    }

}
