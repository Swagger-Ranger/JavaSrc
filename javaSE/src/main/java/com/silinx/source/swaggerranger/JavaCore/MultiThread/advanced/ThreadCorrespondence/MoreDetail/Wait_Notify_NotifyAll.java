package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadCorrespondence.MoreDetail;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Wait_Notify_NotifyAll
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/10 0:44
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class Wait_Notify_NotifyAll {

    private volatile int signal;

    public synchronized int getSignal() {
        System.out.println(Thread.currentThread().getName() + "方法开始执行...");
        if (signal != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "方法执行完成...");
        return signal;
    }

    public synchronized void setSignal() {
        this.signal = 1;
        notify();//随机唤醒一个等待地线程
//        notifyAll();//唤醒所有等待地线程
        System.out.println(Thread.currentThread().getName() + "唤醒线程...");

    }

    public static void main( String[] args ) {
        Wait_Notify_NotifyAll wnn = new Wait_Notify_NotifyAll();

        Thread_1 thread_1 = new Thread_1(wnn);
        Thread_2 thread_2 = new Thread_2(wnn);

        new Thread(thread_1,"Waker").start();


        new Thread(thread_2).start();
        new Thread(thread_2).start();
        new Thread(thread_2).start();
        new Thread(thread_2).start();
        new Thread(thread_2).start();
        new Thread(thread_2).start();

//        new Thread(thread_1).start();

    }
}
