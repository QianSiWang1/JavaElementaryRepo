package com.qy._08_io;

import java.util.Scanner;

/**
 * @Author QianSiWang
 * @Date 2022/8/18 21:04
 * @Description
 */
public class Systeminout {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        System.out.println(a);
        String s = sc.nextLine();
        System.out.println(s);
        /*
         ->12
         12
         ->123
         123
         */
    }
}
