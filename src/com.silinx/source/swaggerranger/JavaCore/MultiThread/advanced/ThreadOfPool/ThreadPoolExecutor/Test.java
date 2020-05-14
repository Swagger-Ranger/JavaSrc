package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadOfPool.ThreadPoolExecutor;

import java.util.concurrent.TimeUnit;

import static com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadOfPool.ThreadPoolExecutor.TimedRun.taskExec;
import static com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadOfPool.ThreadPoolExecutor.TimedRun.timedRun;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/4/8 18:51
 */

public class Test {
    public static void main( String[] args ) {
        taskExec.allowCoreThreadTimeOut(true);
        Runnable myRunnable = () -> {
            try {
                Thread.sleep(1200);
                System.out.println(Thread.currentThread().getName() + " run");
            } catch (InterruptedException e) {
                System.out.println("---------------" + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
                System.out.println("线程中断");
            }
        };

        timedRun(myRunnable, 2, TimeUnit.SECONDS);
        timedRun(myRunnable, 1, TimeUnit.SECONDS);
        timedRun(myRunnable, 2, TimeUnit.SECONDS);
        timedRun(myRunnable, 1, TimeUnit.SECONDS);
        timedRun(myRunnable, 2, TimeUnit.SECONDS);

        System.out.println("---------执行休眠------------");

        try {
            Thread.sleep(31000);
            System.out.println(taskExec.isShutdown());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        taskExec.shutdown();
        System.out.println(taskExec.isShutdown());


        timedRun(myRunnable, 2, TimeUnit.SECONDS);
        timedRun(myRunnable, 1, TimeUnit.SECONDS);
        timedRun(myRunnable, 2, TimeUnit.SECONDS);
        timedRun(myRunnable, 1, TimeUnit.SECONDS);
        timedRun(myRunnable, 2, TimeUnit.SECONDS);

    }
}
