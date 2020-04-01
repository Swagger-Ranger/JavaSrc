package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadCorrespondence;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfWaitNotify
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/9 23:55
 * @Description: Wait和Notify
 * @Aha-eureka:  线程之间的通信实际上可以简化成多个线程之间共享一个int值，然后通过int值来调度个线程的状态
 *              wait(),notify()都是对锁使用的，也就是要放入同步代码块中才能使用同时要对锁的同一个对象调用wait和notify才能生效即object.wait()或者object.notify()
 *                          当使用synchronized修饰方法时则是默认锁地当前对象，所以可以直接写成wait()和notify()
 *              wait：调用wait方法的线程会释放掉锁
 *              notify：调用notify会随机地去唤醒一个等待地线程，注意是随机地
 *              notifyAll()方法则会唤醒所有等待地线程
 *******************************************************************************/

public class ThreadOfWaitNotify {

    private volatile int signal;

    public int getSignal() {
        return signal;
    }

    public void setSignal( int signal ) {
        this.signal = signal;
    }

    public static void main( String[] args ) {
        ThreadOfWaitNotify t = new ThreadOfWaitNotify();

        new Thread(() -> {
            synchronized (t) {
                System.out.println("修改线程状态...");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                t.setSignal(1);
                System.out.println("修改线程状态成功...");
                t.notify();
            }

        }).start();

        new Thread(() -> {
            synchronized (t) {
                while (t.getSignal() != 1) {
                    try {
                        t.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("模拟线程成功运行...");

            }

        }).start();
    }
}
