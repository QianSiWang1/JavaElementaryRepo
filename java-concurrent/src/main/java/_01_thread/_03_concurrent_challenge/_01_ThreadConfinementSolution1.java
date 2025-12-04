package _01_thread._03_concurrent_challenge;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author qy
 */
public class _01_ThreadConfinementSolution1 {
    /**
     * 方案1：栈封闭
     */
    public void stackConfinement() {
        // 局部变量 - 每个线程有自己的副本
        int localCounter = 0;
        for (int i = 0; i < 100; i++) {
            localCounter++;  // 线程安全，因为每个线程有自己的栈
        }
    }
}
