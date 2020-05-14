package com.silinx.source.jcip;

import com.silinx.source.onjava8.Nap;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description 使用Future限定时间获取结果或者取消任务
 *      如果在限定时间内任务线程抛出异常那么会被调用get线程所捕获，不会阻塞主线程
 *      如果等待超时，即使任务线程执行会抛出异常调用线程也不会捕获到，而是直接抛出TimeoutException异常，不会阻塞主线程
 *
 *      最后主线程的退出要等待销毁线程等一系列线程执行完自动退出，不会阻塞主线程
 * @since 2020/4/7 15:18
 */

public class TimedRunTest {

    private static final ExecutorService taskExec = Executors.newCachedThreadPool();
//    private static final ExecutorService taskExec = new ThreadPoolExecutor()

    /**
     * 这里不处理中断，所以将interruptedException 交由上层调用者处理
     *
     * @throws InterruptedException
     */
    public static <T> T get( Callable<T> callable, long timeout, TimeUnit unit )
            throws InterruptedException {

        Future<T> task = taskExec.submit(callable);
        T result = null;
        try {
            result = task.get(timeout, unit);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("结果获取超时");
            e.printStackTrace();
        } finally {
            /**
             * 尝试取消执行此任务。
             *     如果任务已经完成，已经被取消或由于某种其他原因而无法取消，则此尝试将失败。
             *     如果成功，并且当cancel时此任务尚未启动，则此任务不应运行。
             *     如果任务已经开始，那么mayInterruptIfRunning参数确定是否执行此任务的线程应该以试图停止任务被中断。
             * 此方法返回后，后续调用isDone()将始终返回true 。 随后电话isCancelled()总是返回true如果此方法返回true 。
             * 参数- true如果执行该任务的线程应该被中断; 否则，正在进行的任务被允许完成
             */
            //取消任务，因为即使已经完成也不会造成坏的影响，如果没有完成则因为在限定时间内获取结果所以不再需要结果
            task.cancel(true);
        }
        return result;
    }

    public static <T>T getCompletable( Callable<T> callable, long timeout, TimeUnit unit )
            throws InterruptedException {

//        CompletableFuture cf= CompletableFuture.runAsync()

        CompletableFuture<T> future = new CompletableFuture<>();
//        Future<T> task = taskExec.submit(callable);
        taskExec.submit(() -> {
            try {
                future.complete(callable.call());
            } catch (Throwable t) {
                future.completeExceptionally(t);
            }
        });

        T result = null;
        try {
            result = future.get(timeout, unit);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

//        T result = null;
//        try {
//            result = (T) task.get(timeout, unit);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            System.out.println("结果获取超时");
//            e.printStackTrace();
//        } finally {
//            /**
//             * 尝试取消执行此任务。
//             *     如果任务已经完成，已经被取消或由于某种其他原因而无法取消，则此尝试将失败。
//             *     如果成功，并且当cancel时此任务尚未启动，则此任务不应运行。
//             *     如果任务已经开始，那么mayInterruptIfRunning参数确定是否执行此任务的线程应该以试图停止任务被中断。
//             * 此方法返回后，后续调用isDone()将始终返回true 。 随后电话isCancelled()总是返回true如果此方法返回true 。
//             * 参数- true如果执行该任务的线程应该被中断; 否则，正在进行的任务被允许完成
//             */
//            //取消任务，因为即使已经完成也不会造成坏的影响，如果没有完成则因为在限定时间内获取结果所以不再需要结果
//            task.cancel(true);
//        }
        return result;

    }

    public static void get( Runnable r, long timeout, TimeUnit unit )
            throws InterruptedException {

        Future task = taskExec.submit(r);
        try {
            task.get(timeout, unit);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) throws InterruptedException {
        String s = TimedRunTest.get(() -> {
            /**
             * public class Nap {
             *   public Nap(double t) { // Seconds
             *     try {
             *       TimeUnit.MILLISECONDS.sleep((int)(1000 * t));
             *     } catch(InterruptedException e) {
             *       throw new RuntimeException(e);
             *     }
             *   }
             *   public Nap(double t, String msg) {
             *     this(t);
             *     System.out.println(msg);
             *   }
             * }
             */
            new Nap(10);
//            throw new IllegalStateException("状态异常");
            throw new IOException("状态异常");
        }, 5000, TimeUnit.MILLISECONDS);
        System.out.println(s);

        TimedRunTest.get(()->{
            new Nap(1);
//            throw new IllegalStateException("状态异常");
            throw new IOException("状态异常");

        },5000,TimeUnit.MILLISECONDS);
    }


    static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager var1 = System.getSecurityManager();
            this.group = var1 != null?var1.getThreadGroup():Thread.currentThread().getThreadGroup();
            this.namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable var1) {
            Thread var2 = new Thread(this.group, var1, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if(var2.isDaemon()) {
                var2.setDaemon(false);
            }

            if(var2.getPriority() != 5) {
                var2.setPriority(5);
            }

            return var2;
        }}
}



