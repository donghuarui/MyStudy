package com.dhr.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/22 22:09
 * @Description: test sleep
 */
public class TestSleep {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            //获取当前时间
            Date date = new Date(System.currentTimeMillis());
            Thread.sleep(1000);
            String date_string = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            System.out.println(date_string);
        }
    }
}