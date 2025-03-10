package com.qy.basictype;

import org.junit.Test;

/**
 * @Author QianSiWang
 * @Date 2024/3/10 11:59
 * @Description
 */
public class BasicTypeTest {
    public static final char LETTER_A = 'A';

    // 字符串常量
    public static final String GREETING_MESSAGE = "Hello,world!";
    public static void main(String[] args) {
        System.out.println("字符型常量占用的字节数为："+Character.BYTES);
        System.out.println("字符串常量占用的字节数为："+GREETING_MESSAGE.getBytes().length);
    }

}
