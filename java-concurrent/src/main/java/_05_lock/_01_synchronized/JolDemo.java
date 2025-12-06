package _05_lock._01_synchronized;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author qy
 */
public class JolDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 利用jol查看64位系统java对象（空对象），默认开启指针压缩，总大小显示16字节，前12字节为对象头
         * - OFFSET：偏移地址，单位字节；
         * - SIZE：占用的内存大小，单位为字节；
         * - TYPE DESCRIPTION：类型描述，其中object header为对象头；
         * - VALUE：对应内存中当前存储的值，二进制32位；
         * 关闭指针压缩后，对象头为16字节：-XX:-UseCompressedOops
         */
        Object obj = new Object();
        //查看对象内部信息
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
