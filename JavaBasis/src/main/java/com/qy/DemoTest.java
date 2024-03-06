package com.qy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author QianSiWang
 * @Date 2022/10/17 20:11
 * @Description
 */
public class DemoTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        String a = map.get("a");
        System.out.println(a);
        String a_ = map.get("a ");
        System.out.println(a_);

    }
}
