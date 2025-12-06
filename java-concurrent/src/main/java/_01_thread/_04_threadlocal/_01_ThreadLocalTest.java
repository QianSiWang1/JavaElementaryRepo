package _01_thread._04_threadlocal;

public class _01_ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("hello");
        String s = threadLocal.get();
        System.out.println(s);

    }
}
