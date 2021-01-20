package com.silinx.source.onjava8;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description 自定义终止线程
 * @since 2020/4/6 1:55
 */

public class QuittableTask implements Runnable {

    final int id;
    public QuittableTask(int id) {
        this.id = id;
    }
    private AtomicBoolean running =
            new AtomicBoolean(true);
    public void quit() {
        running.set(false);
    }
    @Override
    public void run() {
        while(running.get())         // [1]
            new Nap(0.1);
        System.out.print(id + " ");  // [2]
    }
}
