package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadOfPool.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * TimedRun
 * <p/>
 * Cancelling a task using Future
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TimedRun {
     static final ThreadPoolExecutor taskExec = new ThreadPoolExecutor(
            2,
            4,
            5,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(1));

    public static void main( String[] args ) {
        taskExec.allowCoreThreadTimeOut(true);
        System.out.println("核心线程数" + taskExec.getCorePoolSize());
        System.out.println("线程池数" + taskExec.getPoolSize());
        System.out.println("队列任务数" + taskExec.getQueue().size());

        Runnable myRunnable = () -> {
            try {
                Thread.sleep(1200);
                System.out.println(Thread.currentThread().getName() + " run");
            } catch (InterruptedException e) {
//                System.out.println("---------------" + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
//                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
                System.out.println("线程中断");
            }
        };

        timedRun(myRunnable, 2, TimeUnit.SECONDS);
        timedRun(myRunnable, 1, TimeUnit.SECONDS);
        timedRun(myRunnable, 2, TimeUnit.SECONDS);

        System.out.println("---------执行休眠------------");

        try {
            Thread.sleep(3000);
            System.out.println(taskExec.isShutdown());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(taskExec.isShutdown());
        System.out.println("核心线程数" + taskExec.getCorePoolSize());
        System.out.println("线程池数" + taskExec.getPoolSize());
        System.out.println("队列任务数" + taskExec.getQueue().size());


        timedRun(myRunnable, 2, TimeUnit.SECONDS);
        timedRun(myRunnable, 1, TimeUnit.SECONDS);

        System.out.println("核心线程数" + taskExec.getCorePoolSize());
        System.out.println("线程池数" + taskExec.getPoolSize());
        System.out.println("队列任务数" + taskExec.getQueue().size());

    }

    public static void timedRun( Runnable r,
                                 long timeout, TimeUnit unit ) {

        Future<?> task = taskExec.submit(r);

        /**
         * 直接使用future来取消任务，并且限定时间，如果没有获得结果抛出TimeoutException异常，
         * 如果是其他异常则被封装到ExecutionException异常中
         */
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {
//            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + ": 任务超时");
            System.out.println("执行取消" + task.cancel(true));

        } catch (ExecutionException e) {
            System.out.println(Thread.currentThread().getName() + ": 执行异常，" + e.getCause().getMessage());
//            throw launderThrowable(e.getCause());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": 任务中断");
//        } finally {
//            task.cancel(true); // interrupt if running
        }
    }

}
