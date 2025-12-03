package _01_thread._02_concurrent_feature;

/**
 * @author qy
 */
public class _03_OrderingWithFinal {
    /**
     * final字段的特殊规则：
     * 1. 在构造函数中对final字段的写入
     * 2. 随后将构造对象的引用赋值给一个引用变量
     * 3. 这两步操作不能被重排序
     */
    private final int x;
    private int y;

    public _03_OrderingWithFinal() {
        // final写
        this.x = 3;
        // 普通写
        this.y = 4;
        // x的初始化不会被重排序到构造函数之外
    }
}
