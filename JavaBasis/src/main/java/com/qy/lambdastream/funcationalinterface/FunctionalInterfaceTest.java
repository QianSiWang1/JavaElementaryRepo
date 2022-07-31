package com.qy.lambdastream.funcationalinterface;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author QianSiWang
 * @Date 2022/7/31 15:00
 * @Description 函数式接口
 */
public class FunctionalInterfaceTest {

    // test1方法接收一个函数式接口的参数
    public void test1(MyFunctionalInterface myFunctionalInterface) {
        myFunctionalInterface.method();
    }

    @Test
    public void Test1() {
        new FunctionalInterfaceTest().test1(() -> System.out.println("hello"));
    }

    //================================================================================
    //定义一个方法,方法的参数传递Supplier<T>接口,泛型执行String,get方法就会返回一个String
    public static String getString(Supplier<String> sup) {
        return sup.get();
    }

    /**
     * 测试Supplier函数式接口
     */
    @Test
    public void testSupplier() {
        //调用getString方法,方法的参数Supplier是一个函数式接口,所以可以传递Lambda表达式
        String s = getString(() -> {
            //生产一个字符串,并返回
            return "钱思惘";
        });
        System.out.println(s);

        //优化Lambda表达式
        String s2 = getString(() -> "钱思惘爱学习");
        System.out.println(s2);
    }
//================================================================================

    /*
    定义一个方法
    方法的参数传递一个字符串的姓名
    方法的参数传递Consumer接口,泛型使用String
    可以使用Consumer接口消费字符串的姓名
 */
    public static void method(String name, Consumer<String> con) {
        con.accept(name);
    }

    @Test
    public void testConsumer() {
        //调用method方法,传递字符串姓名,方法的另一个参数是Consumer接口,是一个函数式接口,所以可以传递Lambda表达式
        method("钱思惘", (String name) -> {
            //对传递的字符串进行消费
            //消费方式:直接输出字符串
            //System.out.println(name);

            //消费方式:把字符串进行反转输出
            String reName = new StringBuffer(name).reverse().toString();
            System.out.println(reName);
        });
    }

    /*
   Consumer接口的默认方法andThen
   作用:需要两个Consumer接口,可以把两个Consumer接口组合到一起,在对数据进行消费

   例如:
    Consumer<String> con1
    Consumer<String> con2
    String s = "hello";
    con1.accept(s);
    con2.accept(s);
    连接两个Consumer接口  再进行消费
    con1.andThen(con2).accept(s); 谁写前边谁先消费
    */
    //定义一个方法,方法的参数传递一个字符串和两个Consumer接口,Consumer接口的泛型使用字符串
    public static void method(String s, Consumer<String> con1, Consumer<String> con2) {
        //con1.accept(s);
        //con2.accept(s);
        //使用andThen方法,把两个Consumer接口连接到一起,在消费数据
        con1.andThen(con2).accept(s);//con1连接con2,先执行con1消费数据,在执行con2消费数据
    }

    @Test
    public void testConsumerAndThen() {
        //调用method方法,传递一个字符串,两个Lambda表达式
        method("Hello",
                (t) -> {
                    //消费方式:把字符串转换为大写输出
                    System.out.println(t.toUpperCase());
                },
                (t) -> {
                    //消费方式:把字符串转换为小写输出
                    System.out.println(t.toLowerCase());
                });
    }

//================================================================================

    /*
    定义一个方法
    参数传递一个String类型的字符串
    传递一个Predicate接口,泛型使用String
    使用Predicate中的方法test对字符串进行判断,并把判断的结果返回
 */
    public static boolean checkString(String s, Predicate<String> pre) {
        return pre.test(s);
    }

    @Test
    public void testPredicate() {
        //定义一个字符串
        String s = "abcdef";
        //调用checkString方法对字符串进行校验,参数传递字符串和Lambda表达式
        /*boolean b = checkString(s,(String str)->{
            //对参数传递的字符串进行判断,判断字符串的长度是否大于5,并把判断的结果返回
            return str.length()>5;
        });*/
        //优化Lambda表达式
        boolean b = checkString(s, str -> str.length() > 5);
        System.out.println(b);
    }

    /*
    定义一个方法,方法的参数,传递一个字符串
    传递两个Predicate接口
        一个用于判断字符串的长度是否大于5
        一个用于判断字符串中是否包含a
        两个条件必须同时满足
 */
    public static boolean checkStringAnd(String s, Predicate<String> pre1, Predicate<String> pre2) {
        //return pre1.test(s) && pre2.test(s);
        return pre1.and(pre2).test(s);//等价于return pre1.test(s) && pre2.test(s);
    }

    @Test
    public void testPredicateAnd() {
        //定义一个字符串
        String s = "abcdef";
        //调用checkString方法,参数传递字符串和两个Lambda表达式
        boolean b = checkStringAnd(s, (String str) -> {
            //判断字符串的长度是否大于5
            return str.length() > 8;
        }, (String str) -> {
            //判断字符串中是否包含a
            return str.contains("a");
        });
        System.out.println(b);
    }

    /*
        定义一个方法,方法的参数,传递一个字符串
        传递两个Predicate接口
            一个用于判断字符串的长度是否大于5
            一个用于判断字符串中是否包含a
            满足一个条件即可
     */
    public static boolean checkStringOr(String s, Predicate<String> pre1, Predicate<String> pre2) {
        //return pre1.test(s) || pre2.test(s);
        return pre1.or(pre2).test(s);//等价于return pre1.test(s) || pre2.test(s);
    }

    @Test
    public void testPredicateOr() {
        //定义一个字符串
        String s = "bc";
        //调用checkString方法,参数传递字符串和两个Lambda表达式
        boolean b = checkStringOr(s, (String str) -> {
            //判断字符串的长度是否大于5
            return str.length() > 5;
        }, (String str) -> {
            //判断字符串中是否包含a
            return str.contains("b");
        });
        System.out.println(b);
    }

    /*
       定义一个方法,方法的参数,传递一个字符串
       使用Predicate接口判断字符串的长度是否大于5
*/
    public static boolean checkStringNegate(String s, Predicate<String> pre) {
        //return !pre.test(s);
        return pre.negate().test(s);//等效于return !pre.test(s);
    }

    @Test
    public void testPredicateNegate() {
        //定义一个字符串
        String s = "abc";
        //调用checkString方法,参数传递字符串和Lambda表达式
        boolean b = checkStringNegate(s, (String str) -> {
            //判断字符串的长度是否大于5,并返回结果
            return str.length() > 5;
        });
        System.out.println(b);

    }
//====================================================================================
/*
    java.util.function.Function<T,R>接口用来根据一个类型的数据得到另一个类型的数据，
        前者称为前置条件，后者称为后置条件。
    Function接口中最主要的抽象方法为：R apply(T t)，根据类型T的参数获取类型R的结果。
        使用的场景例如：将String类型转换为Integer类型。
 */

    /*
         定义一个方法
         方法的参数传递一个字符串类型的整数
         方法的参数传递一个Function接口,泛型使用<String,Integer>
         使用Function接口中的方法apply,把字符串类型的整数,转换为Integer类型的整数
      */
    public static void change(String s, Function<String, Integer> fun) {
        //Integer in = fun.apply(s);
        int in = fun.apply(s);//自动拆箱 Integer->int
        System.out.println(in);
    }

    @Test
    public void testFunction() {
        //定义一个字符串类型的整数
        String s = "1234";
        //调用change方法,传递字符串类型的整数,和Lambda表达式
        change(s, (String str) -> {
            //把字符串类型的整数,转换为Integer类型的整数返回
            return Integer.parseInt(str);
        });
        //优化Lambda
        change(s, str -> Integer.parseInt(str));
    }

    /*
    定义一个方法
    参数串一个字符串类型的整数
    参数再传递两个Function接口
        一个泛型使用Function<String,Integer>
        一个泛型使用Function<Integer,String>
 */
    public static void changeAndThen(String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
        String ss = fun1.andThen(fun2).apply(s);
        System.out.println(ss);
    }

    @Test
    public void testFunctionAndThen() {
        //定义一个字符串类型的整数
        String s = "123";
        //调用change方法,传递字符串和两个Lambda表达式
        changeAndThen(s, (String str) -> {
            //把字符串转换为整数+10
            return Integer.parseInt(str) + 10;
        }, (Integer i) -> {
            //把整数转换为字符串
            return i + "";
        });

        //优化Lambda表达式
        changeAndThen(s, str -> Integer.parseInt(str) + 10, i -> i + "");
    }
}

