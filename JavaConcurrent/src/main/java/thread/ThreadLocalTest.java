package thread;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("hello");
        String s = threadLocal.get();
        System.out.println(s);

    }
}
