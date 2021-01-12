package com.silinx.source.jcip;

import java.util.*;
import java.util.concurrent.*;

/**
 * TrackingExecutor
 * <p/>
 * ExecutorService that keeps track of cancelled tasks after shutdown
 *
 * @author Brian Goetz and Tim Peierls
 * 继承AbstractExecutorService类（AbstractExecutorService是一个适配器模式，ThreadPoolExecutor也是继承的此类），
 * 然后实现接口的方法，在execute方法中保留因为取消而中断的任务。这样就能保留取消了正在执行的任务。进而解决List<Runnable> shutdownNow()
 * 只能返回还没有执行的任务，未保留正在执行而被取消的任务
 */
@JCIPCodeInfo(chapter = "7.2.5", page = "130")
public class TrackingExecutor extends AbstractExecutorService {
    private final ExecutorService exec;
    private final Set<Runnable> tasksCancelledAtShutdown =
            Collections.synchronizedSet(new HashSet<Runnable>());

    public TrackingExecutor( ExecutorService exec) {
        this.exec = exec;
    }

    public void shutdown() {
        exec.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return exec.shutdownNow();
    }

    public boolean isShutdown() {
        return exec.isShutdown();
    }

    public boolean isTerminated() {
        return exec.isTerminated();
    }

    public boolean awaitTermination(long timeout, TimeUnit unit)
            throws InterruptedException {
        return exec.awaitTermination(timeout, unit);
    }

    public List<Runnable> getCancelledTasks() {
        if (!exec.isTerminated())
            throw new IllegalStateException(/*...*/);
        return new ArrayList<Runnable>(tasksCancelledAtShutdown);
    }

    public void execute(final Runnable runnable) {
        exec.execute(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } finally {
                    if (isShutdown()
                            && Thread.currentThread().isInterrupted())
                        tasksCancelledAtShutdown.add(runnable);
                }
            }
        });
    }
}
