package com.silinx.source.swaggerranger.mylib;

import java.util.concurrent.Phaser;

/**
 * 通过Phaser控制多个线程的执行时机：有时候我们希望所有线程到达指定点后再同时开始执行,cyclicBarrier
 */
public class PhaserTest1 {
    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        for (int i = 0; i < 5; i++) {
            phaser.register();                  // 注册各个参与者线程
            new Thread(new Task(phaser), "Thread-" + i).start();
        }
    }
}

class Task implements Runnable {
    private final Phaser phaser;

    Task(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        int i = phaser.arriveAndAwaitAdvance();     // 等待其它参与者线程到达
        // do something
        System.out.println(Thread.currentThread().getName() + ": 执行完任务，当前phase =" + i + "");
    }
}

