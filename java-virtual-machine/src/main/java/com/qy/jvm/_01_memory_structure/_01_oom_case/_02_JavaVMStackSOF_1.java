package com.qy.jvm._01_memory_structure._01_oom_case;

/**
 * VM Args：-Xss128k
 *
 * @author zzm
 */
public class _02_JavaVMStackSOF_1 {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        _02_JavaVMStackSOF_1 oom = new _02_JavaVMStackSOF_1();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
