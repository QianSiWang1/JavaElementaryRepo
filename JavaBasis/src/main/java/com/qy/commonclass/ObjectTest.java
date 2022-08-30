package com.qy.commonclass;

import org.junit.Test;

/**
 * @Author QianSiWang
 * @Date 2022/8/30 23:32
 * @Description
 */
public class ObjectTest {

    @Test
    public void test1() {
        //lombok @Data 的效果
        User qy = new User("qy", 25,null);
        System.out.println(qy);
    }

    @Test
    public void test2() throws CloneNotSupportedException {
        User qy = new User("qy", 25,new User("qyy",2,null));
        User clone = qy.clone();
        System.out.println(clone==qy);//false，浅克隆
        System.out.println(clone.getSon()==qy.getSon());//true,原因是浅克隆
    }
}
