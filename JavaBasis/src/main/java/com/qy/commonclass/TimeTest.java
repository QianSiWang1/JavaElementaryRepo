package com.qy.commonclass;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author QianSiWang
 * @Date 2022/9/12 13:09
 * @Description 常用的时间类
 */
public class TimeTest {
    @Test
    public void test1() throws ParseException {

        //获取时间戳的方式
        long time1 = new Date().getTime();
        long time2 = System.currentTimeMillis();
        long time3 = Calendar.getInstance().getTimeInMillis();
        System.out.println("TimeStamp1 is " + time1);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat1.format(time1);
        System.out.println(format1);
        Date parse1 = simpleDateFormat1.parse("2020-10-14 14:12:41");
        System.out.println(parse1);
        System.out.println("TimeStamp2 is " + time2);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("YYYY/MM/dd HH/mm/ss");
        String format2 = simpleDateFormat2.format(time2);
        System.out.println(format2);
        Date parse2 = simpleDateFormat2.parse("2020/101/4 14/12/41");
        System.out.println(parse2);
        System.out.println("TimeStamp3 is " + time3);
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("YYYY年MM月dd日 HH时mm分ss秒");
        String format3 = simpleDateFormat3.format(time3);
        System.out.println(format3);
        Date parse3 = simpleDateFormat3.parse("2020年10月14日 14时12分41秒");
        System.out.println(parse3);


    }
}
