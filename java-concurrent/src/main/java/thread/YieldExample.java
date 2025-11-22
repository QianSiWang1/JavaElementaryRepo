package thread;

public class YieldExample {
    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("生产者: " + i);
                Thread.yield(); // 让出 CPU 资源
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("消费者: " + i);
                Thread.yield(); // 让出 CPU 资源
            }
        });

        producer.start();
        consumer.start();
    }
}
