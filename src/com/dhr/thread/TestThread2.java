package com.dhr.thread;

/**
 * @Auther: 皮卡丘的三只耳朵
 * @Date: 2020/2/22 17:08
 * @Description: 实现 Runnable 接口
 * 模拟 龟兔赛跑 兔子睡觉  最后 乌龟赢
 */
public class TestThread2 implements Runnable {
    private static String winner = null;

    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (this.gameOver(i)) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "==>跑了" + i + "步");
        }
    }

    private Boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("游戏结束");
                System.out.println("胜利者是" + Thread.currentThread().getName());
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TestThread2 thread = new TestThread2();
        new Thread(thread, "兔子").start();
        new Thread(thread, "乌龟").start();
    }
}