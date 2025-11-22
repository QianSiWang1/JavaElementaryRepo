package thread;

public class startAndRun {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread() + "hello");
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread() + "hello");
        });
        thread.setName("新线程");
        thread.run();
        thread.start();
    }
}
