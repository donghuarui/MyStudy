package com.dhr.thread;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/22 22:26
 * @Description: 线程插队
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("vip来了" + i);
            }
        });
        thread.start();
        for (int i = 0; i < 50; i++) {
            System.out.println("我在排队" + i);
            if (i == 20)
                thread.join();//插队
        }
    }
}