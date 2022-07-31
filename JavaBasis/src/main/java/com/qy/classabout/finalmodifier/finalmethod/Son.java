package com.qy.classabout.finalmodifier.finalmethod;

/**
 * @Author QianSiWang
 * @Date 2022/7/28 19:46
 * @Description
 */
public class Son extends FinalFather{
    public static void main(String[] args) {
        FinalFather ff = new Son();
        ff.commonMethod();
        ff.finalMethod();
    }

//    // 不能被重写，会直接报错
//    public final void finalMethod(){
//        System.out.println("This is final method");
//    }

    @Override
    public void commonMethod() {
        //super.commonMethod();
        System.out.println("override commonMethod");

    }
}
