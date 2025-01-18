package future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> ids = new ArrayList<>();
        // 假设我们有一系列ID需要处理
        for (int i = 0; i < 100; i++) {
            ids.add(i);
        }
        List<String> res = new ArrayList<>();
        // 使用CompletableFuture并行处理这些任务
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int id : ids) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> doSomeHeavyTask(id,res));
            futures.add(future);
        }
        // 使用CompletableFuture.allOf等待所有任务完成
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        // 当所有任务都完成时，可以执行后续操作（这里只是简单地等待）
        allFutures.get(); // 这会阻塞，直到所有任务完成
        System.out.println(res);
        System.out.println(res.size());

    }

    public static void doSomeHeavyTask(int id,List<String> list) {
        try {
            // 模拟耗时操作
            System.out.println(id + "开始了");
            Thread.sleep(500L ); // 假设每个任务需要1秒钟
            System.out.println(id + "执行了");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        }
        //这个list有并发问题
        list.add(String.valueOf(id));
    }
}
