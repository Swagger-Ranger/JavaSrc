package com.silinx.source.jcip;

import java.util.concurrent.*;

import static com.silinx.source.jcip.LaunderThrowable.launderThrowable;

/**
 * TimedRun
 * <p/>
 * Cancelling a task using Future
 *
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "7.1.5",page = "121")
public class TimedRun {
    private static final ExecutorService taskExec = Executors.newCachedThreadPool();

    public static void timedRun( Runnable r,
                                 long timeout, TimeUnit unit)
            throws InterruptedException {
        Future<?> task = taskExec.submit(r);

        /**
         * 直接使用future来取消任务，并且限定时间，如果没有获得结果抛出TimeoutException异常，
         * 如果是其他异常则被封装到ExecutionException异常中
         */
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {
            e.printStackTrace();
            // task will be cancelled below
        } catch (ExecutionException e) {
            e.printStackTrace();
            // exception thrown in task; rethrow
            throw launderThrowable(e.getCause());
        } finally {
            // Harmless if task already completed
            task.cancel(true); // interrupt if running
        }
//        try {
//            task.get(timeout, unit);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }
    }

}
