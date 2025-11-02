package com.qy._01_basic;

/**
 * 这是文档注释
 * @author 浅语
 * @since 2022/8/17 18:14
 */
public class _01_Comment {
    // 这是单行注释

    /*
     * 这是多行注释
     */


    /**
     * 这是文档注释
     * javadoc -d mydocs -author -version -encoding UTF-8 _01_Comment.java
     * @param firstName 第一个名字
     * @param lastName 最后一个名字
     * @return 名字
     */
    public String getName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
