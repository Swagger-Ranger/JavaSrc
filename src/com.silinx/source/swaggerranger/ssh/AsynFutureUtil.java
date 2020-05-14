package com.silinx.source.swaggerranger.ssh;

//import org.slf4j.Logger;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.function.BiConsumer;

import static com.silinx.source.jcip.LaunderThrowable.launderThrowable;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description 异步调用future工具
 * @since 2020/4/10 16:12
 * 作用：
 *     1.使用ThreadPoolExecutor来管理线程池：维护核心线程数，限定最大线程数
 *     2.对SSH发起的连接和执行的ssh脚本调用请求，在限定时间内获取执行结果也就是返回码，如果超过一小时则不再等待，结束任务
 */

//@Component
public class AsynFutureUtil {

    private static final int corePoolSize = 1;//核心线程数
    private static final int maxPoolSize = 30;//最大线程数
    private static final int keepAliveTime = 1;//非核心线程等待销毁时间
    private static final int queueCapacity = 50;//请求队列最大长度
    private static final TimeUnit keepAliveTimeUnit = TimeUnit.HOURS;

    private static final int taskWaitTime = 1;//任务结果等待时长
    private static final TimeUnit taskWaitTimeUnit = TimeUnit.HOURS;

    private static final ThreadPoolExecutor taskExec = new ThreadPoolExecutor(
            corePoolSize,
            maxPoolSize,
            keepAliveTime,
            keepAliveTimeUnit,
            new LinkedBlockingDeque<>(queueCapacity));

    static {
        taskExec.allowCoreThreadTimeOut(true);
    }

    /**
     * 这个异步执行的中断策略是针对应用与备份应用，如果业务场景不一致则改写catch中的中断处理
     */
//    @Async
    public <T, U> void asynExecute(Callable<T> task,
                                   U model,
                                   BiConsumer<TimeoutException, U> timeOutHandler,
                                   BiConsumer<Throwable, U> exceptionHandler,
                                   BiConsumer<T, U> afterHandler) {

        try {
            //这里发起调用，并设置等待结果的限时，以及传入对调用异常的处理
            timedRun(
                    task, taskWaitTime, taskWaitTimeUnit, model, timeOutHandler, exceptionHandler, afterHandler);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();//恢复中断,因为有可能时取消任务结果等待导致的任务取消
        }
    }


    /**
     * 在线程池中限时运行一个线程任务，并对等待运行时间内的异常作处理
     *
     * @param r       运行的线程任务
     * @param timeout 时间数
     * @param unit    时间单位
     * @throws InterruptedException 中断异常不处理，由上层调用者处理
     */
    private static <T, U> void timedRun(Runnable r,
                                        long timeout, TimeUnit unit) throws InterruptedException {

        Future<?> task = taskExec.submit(r);
        /**
         * 直接使用future来取消任务，并且限定时间，如果没有获得结果抛出TimeoutException异常，
         * 如果是其他异常则被封装到ExecutionException异常中
         */
        try {
            task.get(timeout, unit);
        } catch (TimeoutException e) {

        } catch (ExecutionException e) {
                throw launderThrowable(e.getCause());
        }
    }

    /**
     * @param r                运行的线程任务
     * @param timeout          时间数
     * @param unit             时间单位
     * @param timeOutHandler   超时后的处理方法
     * @param exceptionHandler 调用异常的处理方法
     * @param model            真正要处理的对象
     * @param afterHandler     对最后执行结果的处理，即返回结果T为什么时，处理对象U需要作什么操作
     * @param <T>              SSH调用的返回结果
     * @param <U>              处理的对象
     * @return
     * @throws InterruptedException
     */
    private static <T, U> void timedRun(Callable<T> r,
                                        long timeout, TimeUnit unit,
                                        U model,
                                        BiConsumer<TimeoutException, U> timeOutHandler,
                                        BiConsumer<Throwable, U> exceptionHandler,
                                        BiConsumer<T, U> afterHandler) throws InterruptedException {

        Future<?> task = taskExec.submit(r);
        T result = null;
        /**
         * 直接使用future来取消任务，并且限定时间，如果没有获得结果抛出TimeoutException异常，
         * 如果是其他异常则被封装到ExecutionException异常中
         */
        try {
            result = (T) task.get(timeout, unit);
        } catch (TimeoutException e) {
            timeOutHandler.accept(e, model);
        } catch (ExecutionException e) {
            exceptionHandler.accept(e, model);
        }

        afterHandler.accept(result, model);

    }
}
