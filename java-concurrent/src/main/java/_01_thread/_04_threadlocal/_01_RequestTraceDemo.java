package _01_thread._04_threadlocal;


import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 场景：Web请求链路追踪
 * 每个请求分配唯一Trace ID，在调用链中传递
 *
 * @Author qy
 * @Date 2025/12/7
 */
public class _01_RequestTraceDemo {

    // ThreadLocal用于存储当前线程的Trace ID
    private static final ThreadLocal<String> traceIdHolder = new ThreadLocal<>();

    // 模拟的Service类
    static class OrderService {
        public void createOrder() {
            // 获取当前线程的Trace ID
            String traceId = traceIdHolder.get();
            System.out.println(Thread.currentThread().getName() + " - [OrderService] TraceID: " + traceId + ", 创建订单");

            // 调用其他服务
            new PaymentService().processPayment();
        }
    }

    static class PaymentService {
        public void processPayment() {
            String traceId = traceIdHolder.get();
            System.out.println(Thread.currentThread().getName() + " - [PaymentService] TraceID: " + traceId + ", 处理支付");

            // 调用其他服务
            new LogService().logOperation();
        }
    }

    static class LogService {
        public void logOperation() {
            String traceId = traceIdHolder.get();
            System.out.println(Thread.currentThread().getName() + " - [LogService] TraceID: " + traceId + ", 记录日志");
        }
    }

    // 模拟HTTP请求处理器
    static class RequestHandler implements Runnable {
        private final String requestId;

        public RequestHandler(String requestId) {
            this.requestId = requestId;
        }

        @Override
        public void run() {
            try {
                // 1. 请求开始时设置Trace ID
                String traceId = "TRACE-" + UUID.randomUUID().toString().substring(0, 8);
                traceIdHolder.set(traceId);

                System.out.println(Thread.currentThread().getName() + " - [RequestHandler] 开始处理请求: " + requestId +
                        ", TraceID: " + traceId);

                // 2. 执行业务逻辑（调用链）
                new OrderService().createOrder();

                // 3. 模拟其他操作
                Thread.sleep(100); // 模拟处理时间

                System.out.println(Thread.currentThread().getName() + " - [RequestHandler] 完成请求: " + requestId);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 4. 非常重要：清理ThreadLocal，避免内存泄漏
                traceIdHolder.remove();
                System.out.println(Thread.currentThread().getName() + " - [RequestHandler] 清理ThreadLocal");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== ThreadLocal 请求追踪Demo ===");

        // 使用线程池模拟服务器处理多个请求
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 模拟5个并发请求
        for (int i = 1; i <= 5; i++) {
            executor.execute(new RequestHandler("REQ-" + i));
            Thread.sleep(50); // 间隔启动请求
        }

        executor.shutdown();

        // 等待所有任务完成
        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }

        System.out.println("=== 所有请求处理完成 ===");
    }
}
