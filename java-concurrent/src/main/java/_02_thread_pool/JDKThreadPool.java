package _02_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JDKThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
    }
}
