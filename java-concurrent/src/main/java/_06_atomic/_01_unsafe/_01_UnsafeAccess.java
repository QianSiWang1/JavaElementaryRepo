//package _06_atomic._01_unsafe;
//
//
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
///**
// * @Author qy
// * @Date 2025/12/6
// */
//public class _01_UnsafeAccess {
//    public static void main(String[] args) {
//        // 这个jdk8才行，jdk21不行
//        Unsafe unsafeWithReflection = getUnsafeWithReflection();
//        //Unsafe unsafePrivileged = getUnsafePrivileged();
//        System.out.println(unsafeWithReflection);
//    }
//    // 方式1：通过反射获取（推荐）
//    public static Unsafe getUnsafeWithReflection() {
//        try {
//            Field field = Unsafe.class.getDeclaredField("theUnsafe");
//            field.setAccessible(true);
//            return (Unsafe) field.get(null);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    // 方式2：通过特权代码（需要 SecurityManager 允许）
//    public static Unsafe getUnsafePrivileged() {
//        return Unsafe.getUnsafe();
//    }
//
//    // 方式3：使用系统属性（已废弃）
//    // java -Xbootclasspath/a:... -Dunsafe=true
//}
