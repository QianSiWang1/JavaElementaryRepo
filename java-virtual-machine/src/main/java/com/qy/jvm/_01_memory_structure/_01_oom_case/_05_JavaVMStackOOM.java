package com.qy.jvm._01_memory_structure._01_oom_case;

/**
 * VM Args：-Xss2M （这时候不妨设大些，请在32位系统下运行）
 *
 * @author zzm
 */
public class _05_JavaVMStackOOM {

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        _05_JavaVMStackOOM oom = new _05_JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
