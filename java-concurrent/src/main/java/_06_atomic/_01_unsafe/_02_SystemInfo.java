package _06_atomic._01_unsafe;

/**
 * @Author qy
 * @Date 2025/12/6
 */
public class _02_SystemInfo {
//    private static final Unsafe unsafe = getUnsafe();
//
//    public static void main(String[] args) {
//        System.out.println("=== 系统信息 ===");
//
//        // 地址大小（字节）
//        int addressSize = unsafe.addressSize();
//        System.out.println("地址大小: " + addressSize + " 字节 (" +
//                (addressSize * 8) + " 位)");
//
//        // 页大小
//        int pageSize = unsafe.pageSize();
//        System.out.println("内存页大小: " + pageSize + " 字节");
//
//        // 内存分配对齐
//        System.out.println("内存分配对齐: " + unsafe.allocationGranularity());
//
//        // 系统属性
//        System.out.println("Big Endian: " + unsafe.isBigEndian());
//
//        // 获取内存地址（如果支持）
//        Object obj = new Object();
//        try {
//            // 注意：这个方法在标准的HotSpot Unsafe中不存在
//            // 需要特定版本的Unsafe
//            // long address = unsafe.getAddress(obj, 0);
//        } catch (Exception e) {
//            System.out.println("获取内存地址功能不可用");
//        }
//    }
}
