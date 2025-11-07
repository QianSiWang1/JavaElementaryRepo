package com.qy._02_class_about.codeblock;

/**
 * @Author QianSiWang
 * @Date 2022/7/27 22:37
 * @Description
 */
public class SyncCodeBlock {
    public static void main(String[] args) {
        SyncCodeBlock syncCodeBlock = new SyncCodeBlock();
        syncCodeBlock.function1();
    }

    public void function1(){
        synchronized (new Object()){
            System.out.println("同步代码块");
        }
    }
}
