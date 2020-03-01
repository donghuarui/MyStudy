package com.dhr.thread;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/22 15:50
 * @Description: 创建线程1： 继承 Thread 类， 重新 run（） 方法，   调用 start 开启线程
 * 多线程 从网络 下载 图片 到 本地
 */
public class TestThread1 extends Thread {
    private String name;
    private String url;
    private static final String DOWN_URL = "F:\\ideaproject\\MyStudy\\src\\img\\";

    public TestThread1(String url, String name) {
        this.name = name;
        this.url = url;
    }

    public TestThread1() {

    }

    @Override
    public void run() {
        WebDownloader WebDownloader = new WebDownloader();
        WebDownloader.downloader(url, name);
    }

    public static void main(String[] args) {
        TestThread1 thread1 = new TestThread1("https://b318.photo.store.qq.com/psb?/V136lEJl2BhKsY/lswDEpIXfozR8G5NQOuZa4iAYniBKDt75anBZ33.Fyc!/m/dD4BAAAAAAAAnull&bo=gAJlAQAAAAARB9Y!&rf=photolist&t=5", DOWN_URL + "1.jpg");
        TestThread1 thread2 = new TestThread1("https://b349.photo.store.qq.com/psb?/V136lEJl2BhKsY/rmHxuMbu42aorX25N46*4TH7ZtgES0hPft7AZd1lVQQ!/m/dF0BAAAAAAAAnull&bo=iQHcAYkB3AEFCSo!&rf=photolist&t=5", DOWN_URL + "2.jpg");
        TestThread1 thread3 = new TestThread1("https://b370.photo.store.qq.com/psb?/V136lEJl2BhKsY/f9O3FE9U6Cn*nRp3J.FPiE67uC6*.g6KV9AngaNskDc!/m/dHIBAAAAAAAAnull&bo=WAKEAwAAAAAFCfc!&rf=photolist&t=5", DOWN_URL + "3.jpg");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

/**
 * 下载器
 */
class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}