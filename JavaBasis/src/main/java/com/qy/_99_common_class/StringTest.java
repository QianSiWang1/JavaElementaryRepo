package com.qy._99_common_class;

import org.junit.Test;

/**
 * @Author QianSiWang
 * @Date 2022/8/31 22:53
 * @Description
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "aaabbbcccddd";
        //length():获取字符串的长度
        int length = str.length();
        System.out.println(length);//12
        //charAt(int index):获取指定索引处的字符
        char c = str.charAt(6);
        System.out.println(c);//c
        //indexOf(String str):获取str在字符串中第一次出现的索引
        int bb = str.indexOf("bb");
        System.out.println(bb);//3
        //substring(int start,int end):从start开始到end截取字符串，左闭右开
        String substring = str.substring(3, 9);
        System.out.println(substring);//bbbccc
        //equals(Object obj):比较字符串内容是否相同
        String str2="aaddwwee";
        boolean equals = str.equals(str2);
        System.out.println(equals);//false
        //equalsIgnoreCase(String anotherString):比较字符串的内容是否相同,忽略大小写
        String str3 = "aaABBbCCCDDd";
        boolean b = str.equalsIgnoreCase(str3);
        System.out.println(b);//true
        //startsWith(String prefix):判断字符串对象是否以指定的字符开头（区分大小写）
        boolean a = str.startsWith("a");
        System.out.println(a);//true
        //startsWith(String prefix,int toffset)：判断字符串对象是否以指定的字符开头，参数toffset为指定从哪个下标开始
        boolean b1 = str.startsWith("b", 3);
        System.out.println(b1);//true
        //endsWith(String str):判断字符串对象是否以指定的字符结尾
        boolean dd = str.endsWith("dd");
        System.out.println(dd);//true
        //isEmpty()：判断指定字符串是否为空
        boolean empty = str.isEmpty();
        System.out.println(empty);//false
        //toCharArray():把字符串转换为字符数组
        char[] chars = str.toCharArray();
        for(char i : chars) {
            System.out.println(i);
        }
        //toLowerCase():把字符串转换为小写字符串
        String s = str3.toLowerCase();
        System.out.println(s);//aaabbbcccddd
        //toUpperCase():把字符串转换为大写字符串
        String s1 = str.toUpperCase();
        System.out.println(s1);//AAABBBCCCDDD
        //trim()：去除字符串两端空格
        String k = "  a b dd c  ";
        String trim = k.trim();
        System.out.println(trim);//"a b dd c"
        //split():以指定的的字符为分隔符，然后返回一个新的字符串数组
        String sp = "123.456.adb.67.";
        String[] split = sp.split("\\.");
        for(String ss:split) {
            System.out.println(ss);
        }//123 456 abd 67
        //replace(char oldChar, char newChar)：将指定字符替换成另一个指定的字符
        String replace = str.replace("a", "GGMM");
        System.out.println(replace);//"GGMMGGMMGGMMbbbcccddd"
        //replaceAll(String regex,String replasement)：用新的内容替换全部旧内容
        String replace1 = str.replace("a", "ALL");
        System.out.println(replace1);//"ALLALLALLbbbcccddd"
        //replaceFirst(String regex,String replacement)：替换首个满足条件的内容
        String s2 = str.replaceFirst("b", "First");
        System.out.println(s2);//"aaaFirstbbcccddd"
        //lastIndexOf(String str)：返回指定字符出现的最后一次的下标
        int a1 = str.lastIndexOf("a");
        System.out.println(a1);//2
        //contains(CharSequence s)：查看字符串中是都含有指定字符
        boolean cc = str.contains("cc");
        System.out.println(cc);//true
        //concat(String str)：在原有的字符串的基础上加上指定字符串
        String eeeFFF = str.concat("eeeFFF");
        System.out.println(eeeFFF);//"aaabbbcccdddeeeFFF

    }

    @Test
    public void test1(){
        int value[] = {12,3,4,5,6};
        System.out.println(value[1]);
    }
}
