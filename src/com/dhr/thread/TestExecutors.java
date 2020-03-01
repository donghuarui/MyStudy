package com.dhr.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/23 16:40
 * @Description: 线程池
 */
public class TestExecutors {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(thread);
        executorService.execute(thread);
        executorService.execute(thread);
        executorService.shutdown();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程池" + i);
        }
    }
}