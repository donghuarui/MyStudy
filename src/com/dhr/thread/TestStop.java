package com.dhr.thread;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/22 21:32
 * @Description: jdk不建议用 stop()  destroy() 来停止线程 。  希望用  外部方法来干预
 */
public class TestStop {
    private Boolean flag = true;

    public void testThread() {
        new Thread(() -> {
            int i = 0;
            while (!flag) {
                System.out.println("我想停下来" + i++);
            }
        }).start();
    }

    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        testStop.testThread();
        for (int i = 0; i < 100; i++) {
            System.out.println("我是主线程");
            if (i == 95) {
                testStop.stop();
                System.out.println("stop");
            }
        }
    }
}