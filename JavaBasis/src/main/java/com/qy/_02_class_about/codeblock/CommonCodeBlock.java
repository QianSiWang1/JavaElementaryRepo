package com.qy._02_class_about.codeblock;

/**
 * @Author QianSiWang
 * @Date 2022/7/27 22:06
 * @Description 普通代码块
 */
public class CommonCodeBlock {
    public static void main(String[] args) {
        CommonCodeBlock commonCodeBlock = new CommonCodeBlock();
        commonCodeBlock.block1();
    }

    public void block1(){
        {
            System.out.println("This is a common code block 2");
        }

        {
            System.out.println("This is a common code block 1");
        }
    }
}
