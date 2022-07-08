package com.qy.datatypesandoperators;

import org.junit.Test;

/**
 * @Author QianSiWang
 * @Date 2022/7/8 11:12
 * @Description Java的数据类型
 */
public class DataType {

    /**
     * Java中的常量
     */
    @Test
    public void constantTest() {
        // 字符串常量
        System.out.println("ABC");
        System.out.println(""); // 字符串两个双引号中间的内容为空
        System.out.println("XYZ");

        // 整数常量
        System.out.println(30);
        System.out.println(-500);

        // 浮点数常量（小数）
        System.out.println(3.14);
        System.out.println(-2.5);

        // 字符常量
        System.out.println('A');
        System.out.println('6');
        // System.out.println(''); // 两个单引号中间必须有且仅有一个字符，没有不行。
        // System.out.println('AB'); // 两个单引号中间必须有且仅有一个字符，有两个不行。

        // 布尔常量
        System.out.println(true);
        System.out.println(false);

        // 空常量。空常量不能直接用来打印输出。
        // System.out.println(null);
    }

    /**
     * 变量与基本数据类型
     */
    @Test
    public void variableTest() {
        // 创建一个变量
        // 格式：数据类型 变量名称;
        int num1;
        // 向变量当中存入一个数据
        // 格式：变量名称 = 数据值;
        num1 = 10;
        // 当打印输出变量名称的时候，显示出来的是变量的内容
        System.out.println(num1); // 10

        // 改变变量当中本来的数字，变成新的数字
        num1 = 20;
        System.out.println(num1); // 20

        // 使用一步到位的格式来定义变量
        // 格式：数据类型 变量名称 = 数据值;
        int num2 = 25;
        System.out.println(num2); // 25

        num2 = 35;
        System.out.println(num2); // 35
        System.out.println("===============");

        byte num3 = 30; // 注意：右侧数值的范围不能超过左侧数据类型的取值范围
        System.out.println(num3); // 30

        // byte num4 = 400; // 右侧超出了byte数据范围，错误！

        short num5 = 50;
        System.out.println(num5); // 50

        long num6 = 3000000000L;
        System.out.println(num6); // 3000000000

        float num7 = 2.5F;
        System.out.println(num7); // 2.5

        double num8 = 1.2;
        System.out.println(num8); // 1.2

        char zifu1 = 'A';
        System.out.println(zifu1); // A

        zifu1 = '中';
        System.out.println(zifu1); // 中

        boolean var1 = true;
        System.out.println(var1); // true

        var1 = false;
        System.out.println(var1); // false

        // 将一个变量的数据内容，赋值交给另一个变量
        // 右侧的变量名称var1已经存在，里面装的是false布尔值
        // 将右侧变量里面的false值，向左交给var2变量进行存储
        boolean var2 = var1;
        System.out.println(var2); // false
    }

    /**
     * 使用变量的时候，有一些注意事项：
     * 1. 如果创建多个变量，那么变量之间的名称不可以重复。
     * 2. 对于float和long类型来说，字母后缀F和L不要丢掉。
     * 3. 如果使用byte或者short类型的变量，那么右侧的数据值不能超过左侧类型的范围。
     * 4. 没有进行赋值的变量，不能直接使用；一定要赋值之后，才能使用。
     * 5. 变量使用不能超过作用域的范围。
     * 【作用域】：从定义变量的一行开始，一直到直接所属的大括号结束为止。
     * 6. 可以通过一个语句来创建多个变量，但是一般情况不推荐这么写。
     */
    @Test
    public void variableTest2() {
        int num1 = 10; // 创建了一个新的变量，名叫num1
        // int num1 = 20; // 又创建了另一个新的变量，名字也叫num1，错误！

        int num2 = 20;

        int num3;
        num3 = 30;

        int num4; // 定义了一个变量，但是没有进行赋值
        // System.out.println(num4); // 直接使用打印输出就是错误的！

        // System.out.println(num5); // 在创建变量之前，不能使用这个变量

        int num5 = 500;
        System.out.println(num5); // 500

        {
            int num6 = 60;
            System.out.println(num6); // 60
        }
        // int num6;
        // System.out.println(num6); // 已经超出了大括号的范围，超出了作用域，变量不能再使用了

        // 同时创建了三个全都是int类型的变量
        int a, b, c;
        // 各自分别赋值
        a = 10;
        b = 20;
        c = 30;
        System.out.println(a); // 10
        System.out.println(b); // 20
        System.out.println(c); // 30

        // 同时创建三个int变量，并且同时各自赋值
        int x = 100, y = 200, z = 300;
        System.out.println(x); // 100
        System.out.println(y); // 200
        System.out.println(z); // 300
    }


    /**
     * 自动类型转换（隐式）
     * 1. 特点：代码不需要进行特殊处理，自动完成。
     * 2. 规则：数据范围从小到大。
     */
    @Test
    public void dataTypeConversion1() {
        System.out.println(1024); // 这就是一个整数，默认就是int类型
        System.out.println(3.14); // 这就是一个浮点数，默认就是double类型

        // 左边是long类型，右边是默认的int类型，左右不一样
        // 一个等号代表赋值，将右侧的int常量，交给左侧的long变量进行存储
        // int --> long，符合了数据范围从小到大的要求
        // 这一行代码发生了自动类型转换。
        long num1 = 100;
        System.out.println(num1); // 100

        // 左边是double类型，右边是float类型，左右不一样
        // float --> double，符合从小到大的规则
        // 也发生了自动类型转换
        double num2 = 2.5F;
        System.out.println(num2); // 2.5

        // 左边是float类型，右边是long类型，左右不一样
        // long --> float，范围是float更大一些，符合从小到大的规则
        // 也发生了自动类型转换
        float num3 = 30L;
        System.out.println(num3); // 30.0
    }

    /**
     * 强制类型转换
     * 1. 特点：代码需要进行特殊的格式处理，不能自动完成。
     * 2. 格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;
     * <p>
     * 注意事项：
     * 1. 强制类型转换一般不推荐使用，因为有可能发生精度损失、数据溢出。
     * 2. byte/short/char这三种类型都可以发生数学运算，例如加法“+”.
     * 3. byte/short/char这三种类型在运算的时候，都会被首先提升成为int类型，然后再计算。
     * 4. boolean类型不能发生数据类型转换
     */
    @Test
    public void dataTypeConversion2() {
        // 左边是int类型，右边是long类型，不一样
        // long --> int，不是从小到大
        // 不能发生自动类型转换！
        // 格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;
        int num = (int) 100L;
        System.out.println(num);

        // long强制转换成为int类型
        int num2 = (int) 6000000000L;
        System.out.println(num2); // 1705032704

        // double --> int，强制类型转换
        int num3 = (int) 3.99;
        System.out.println(num3); // 3，这并不是四舍五入，所有的小数位都会被舍弃掉

        char zifu1 = 'A'; // 这是一个字符型变量，里面是大写字母A
        System.out.println(zifu1 + 1); // 66，也就是大写字母A被当做65进行处理
        // 计算机的底层会用一个数字（二进制）来代表字符A，就是65
        // 一旦char类型进行了数学运算，那么字符就会按照一定的规则翻译成为一个数字

        byte num4 = 40; // 注意！右侧的数值大小不能超过左侧的类型范围
        byte num5 = 50;
        // byte + byte --> int + int --> int
        int result1 = num4 + num5;
        System.out.println(result1); // 90

        short num6 = 60;
        // byte + short --> int + int --> int
        // int强制转换为short：注意必须保证逻辑上真实大小本来就没有超过short范围，否则会发生数据溢出
        short result2 = (short) (num4 + num6);
        System.out.println(result2); // 100
    }


}
