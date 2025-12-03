package _01_thread._02_concurrent_feature;

/**
 * @author qy
 */
public class _02_VisibilityWithFinal {
    /**
     * final保证可见性的原理：
     * 1. 在构造函数中正确初始化的final字段
     * 2. 构造函数执行完成后，final字段对所有线程可见
     */
    private final int immutableValue;

    public _02_VisibilityWithFinal(int value) {
        this.immutableValue = value;
        // 构造函数执行完成后，immutableValue对所有线程可见
    }

    public int getValue() {
        // 总是能看到正确的初始化值
        return immutableValue;
    }
}
