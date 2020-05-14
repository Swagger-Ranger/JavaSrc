package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadOfPool.ThreadPoolExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/4/8 11:23
 */

public class ThreadPoolExecutorTest {

    public static void main( String[] args ) throws InterruptedException {

        Runnable myRunnable = () -> {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ThreadPoolExecutor executor =
//                new ThreadPoolExecutor(6, 10, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//                new ThreadPoolExecutor(3, 6, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//                new ThreadPoolExecutor(3, 6, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
//                new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1));
                new ThreadPoolExecutor(0, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1));
//                new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1), new ThreadPoolExecutor.DiscardPolicy());
//                new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1), (null,executor)->{
//                    System.out.println("ssss");
//                });


        executor.execute(myRunnable);
        executor.execute(myRunnable);
        executor.execute(myRunnable);
        System.out.println("---先开三个---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());

        try {
            executor.execute(myRunnable);
            executor.execute(myRunnable);
            executor.execute(myRunnable);
        } catch (RejectedExecutionException e) {
            System.out.println(myRunnable + "is discard");
        }

//        executor.execute(myRunnable);
//        executor.execute(myRunnable);
//        executor.execute(myRunnable);
        System.out.println("---再开三个---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
        Thread.sleep(8000);
        System.out.println("----8秒之后----");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
        executor.execute(myRunnable);

    }

    private class RejectedHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution( Runnable r, ThreadPoolExecutor executor ) {

        }
    }

    static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        DefaultThreadFactory() {
            SecurityManager var1 = System.getSecurityManager();//如果设置了安全配置则获取安全管理器配置，默认为null
            this.group = var1 != null ? var1.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        public Thread newThread( Runnable var1 ) {
            /**
             * group - 线程组。 如果null并且有一个安全管理器，该组由SecurityManager.getThreadGroup()确定 。 如果没有安全管理员或SecurityManager.getThreadGroup()返回null ，该组将设置为当前线程的线程组。
             * target - 启动此线程时调用其run方法的对象。 如果null ，这个线程的run方法被调用。
             * name - 新线程的名称
             * stackSize - 新线程所需的堆栈大小，或为零表示此参数将被忽略。
             */
            Thread var2 = new Thread(this.group, var1, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (var2.isDaemon()) {
                var2.setDaemon(false);
            }

            if (var2.getPriority() != 5) {
                var2.setPriority(5);
            }
            return var2;
        }
    }
}
