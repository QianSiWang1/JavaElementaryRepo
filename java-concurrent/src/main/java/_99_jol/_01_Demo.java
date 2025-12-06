package _99_jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author  qy
 */
public class _01_Demo {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        //查看对象内部信息
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
