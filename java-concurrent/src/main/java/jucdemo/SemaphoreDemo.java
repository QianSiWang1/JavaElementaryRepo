package jucdemo;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 模拟限流场景
 */
public class SemaphoreDemo {

    /**
     * 同一时刻最多只允许有两个并发
     */
    private static Semaphore semaphore = new Semaphore(2);

    private static Executor executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            executor.execute(()-> System.out.println(getProductInfo2()));
        }
    }

    public static String getProductInfo() {
        try {
            semaphore.acquire();  //申请许可
            //log.info("请求服务");
            System.out.println("请求服务");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release(); //释放许可
        }
        return "返回商品详情信息";
    }

    public static String getProductInfo2() {

        if(!semaphore.tryAcquire()){
            //log.error("请求被流控了");
            System.out.println("请求被流控了");
            return "请求被流控了";
        }
        try {
            //log.info("请求服务");
            System.out.println("请求服务");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release();
        }
        return "返回商品详情信息";
    }
}
