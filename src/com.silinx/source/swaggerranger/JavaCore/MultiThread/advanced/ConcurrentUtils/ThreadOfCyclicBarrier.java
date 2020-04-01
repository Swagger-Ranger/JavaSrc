package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ConcurrentUtils;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfCyclicBarrier
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/12 14:44
 * @Description: CyclicBarrier使用示例
 * @Aha-eureka: 栅栏可以循环执行，而countLatch则只能执行一次，比如main方法中设置的循环数量减去一个设置了异常，21就会执行两次。
 *******************************************************************************/

public class ThreadOfCyclicBarrier {

    Random random = new Random();

    public void meeting( CyclicBarrier barrier ) {

        try {
            Thread.sleep(random.nextInt(4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "  到达，等待会议开始...");

        if (Thread.currentThread().getName().equals("Thread-1")) {
            throw new RuntimeException("模拟异常，当出现异常后面的await就不会执行");
        }

        try {
            //设置barrier，等待被唤醒
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        //barrier.await() 之后线程继续执行
        System.out.println(Thread.currentThread().getName() + "  会议发言...");
    }

    public static void main( String[] args ) {

        ThreadOfCyclicBarrier tcb = new ThreadOfCyclicBarrier();
        //创建一个新的 CyclicBarrier ，当给定数量的线程（线程）正在等待时，它将跳闸，当屏障跳闸时执行给定的屏障动作，由最后一个进入屏障的线程执行。
        CyclicBarrier barrier = new CyclicBarrier(10, () -> System.out.println(Thread.currentThread().getName() + "不好意思，我是最后一个到的，我们开始开会吧..."));

        for (int i = 0; i < 21; i++) {//栅栏可以循环执行，而countLatch则只能执行一次这里有一个设置了异常，21就会执行两次
            //创建线程，并调用meeting方法将barrier传入方法中
            new Thread(() -> tcb.meeting(barrier)).start();
        }
    }
}
