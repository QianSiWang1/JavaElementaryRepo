package com.qy.inputoutput;

import org.junit.Test;

import java.io.*;

/**
 * @Author QianSiWang
 * @Date 2022/8/20 16:55
 * @Description
 */
public class ReaderTest {
    @Test
    public void test1() throws IOException {
        //1.创建FileReader对象,构造方法中绑定要读取的数据源
        FileReader fr = new FileReader("b.txt");
        //2.使用FileReader对象中的方法read读取文件
        //int read() 读取单个字符并返回。
        //int read = fr.read();
        //System.out.println((char) read);
        //int read(char[] cbuf)一次读取多个字符,将字符读入数组。
        char[] cs = new char[1024];//存储读取到的多个字符
        int len = 0;//
        while((len = fr.read(cs))!=-1){
            /*
         String类的构造方法
         String(char[] value) 把字符数组转换为字符串
         String(char[] value, int offset, int count) 把字符数组的一部分转换为字符串 offset数组的开始索引 count转换的个数
        */
            System.out.println(new String(cs,0,len));
        }
        //3.释放资源
        fr.close();
    }

    @Test
    public void test2() throws IOException {
        //1.创建字符缓冲输入流对象,构造方法中传递字符输入流
        BufferedReader br = new BufferedReader(new FileReader("e.txt"));
        //2.使用字符缓冲输入流对象中的方法read/readLine读取文本
        String line;
        while((line = br.readLine())!=null){
            System.out.println(line);
        }
        //3.释放资源
        br.close();
    }

    @Test
    public void test3() throws IOException {
        //1.创建InputStreamReader对象,构造方法中传递字节输入流和指定的编码表名称
        //InputStreamReader isr = new InputStreamReader(new FileInputStream("10_IO\\gbk.txt"),"UTF-8");//???
        InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"),"GBK");//你好

        //2.使用InputStreamReader对象中的方法read读取文件
        int len = 0;
        while((len = isr.read())!=-1){
            System.out.print((char)len);
        }
        //3.释放资源
        isr.close();
    }

    @Test
    public void test4() throws FileNotFoundException {
        //创建打印流PrintStream对象,构造方法中绑定要输出的目的地
        PrintStream ps = new PrintStream("print.txt");
        //如果使用继承自父类的write方法写数据,那么查看数据的时候会查询编码表 97->a
        ps.write(97);
        //如果使用自己特有的方法print/println方法写数据,写的数据原样输出 97->97
        ps.println(97);
        ps.println(8.8);
        ps.println('a');
        ps.println("HelloWorld");
        ps.println(true);
        //释放资源
        ps.close();
    }

    @Test
    public void test5() throws FileNotFoundException {
        System.out.println("我是在控制台输出");
        PrintStream ps = new PrintStream("out.txt");
        System.setOut(ps);//把输出语句的目的地改变为打印流的目的地
        System.out.println("我在打印流的目的地中输出");
        ps.close();
    }
}
