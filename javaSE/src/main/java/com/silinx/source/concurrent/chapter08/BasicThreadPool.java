package com.silinx.source.concurrent.chapter08;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BasicThreadPool extends Thread implements ThreadPool
{

    private final int initSize;

    private final int maxSize;

    private final int coreSize;

    // 当前活跃的线程数
    private int activeCount;

    private final ThreadFactory threadFactory;

    // 任务队列
    private final RunnableQueue runnableQueue;

    private volatile boolean isShutdown = false;

    // 线程工作队列
    private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();

    private final static DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();

    private final static ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();

    private final long keepAliveTime;

    private final TimeUnit timeUnit;


    public BasicThreadPool(int initSize, int maxSize, int coreSize,
                           int queueSize)
    {
        this(initSize, maxSize, coreSize, DEFAULT_THREAD_FACTORY,
                queueSize, DEFAULT_DENY_POLICY, 10, TimeUnit.SECONDS);
    }

    public BasicThreadPool(int initSize, int maxSize, int coreSize,
                           ThreadFactory threadFactory, int queueSize,
                           DenyPolicy denyPolicy, long keepAliveTime, TimeUnit timeUnit)
    {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.threadFactory = threadFactory;
        this.runnableQueue = new LinkedRunnableQueue(queueSize, denyPolicy, this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.init();
    }

    private void init()
    {
        start();
        for (int i = 0; i < initSize; i++)
        {
            newThread();
        }
    }


    @Override
    public void execute(Runnable runnable)
    {
        if (this.isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        this.runnableQueue.offer(runnable);
    }

    private void newThread()
    {
        InternalTask internalTask = new InternalTask(runnableQueue);
        Thread thread = this.threadFactory.createThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread, internalTask);
        threadQueue.offer(threadTask);
        this.activeCount++;
        thread.start();
    }

    private void removeThread()
    {
        ThreadTask threadTask = threadQueue.remove();
        threadTask.internalTask.stop();
        this.activeCount--;
    }


    @Override
    public void run()
    {

        /**
         * 这里主要在维护线程线程池中的线程和线程数量的生成和销毁，具体的任务执行在InternalTask里面，这里面不断地去取任务队列中的任务来执行
         */
        while (!isShutdown && !isInterrupted())
        {
            try
            {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e)
            {
                isShutdown = true;
                break;
            }

            synchronized (this)
            {
                if (isShutdown)
                    break;
                System.out.println(runnableQueue.size() + "==" + activeCount);
                if (runnableQueue.size() > 0 && activeCount < coreSize)
                {
                    for (int i = initSize; i < coreSize; i++)
                    {
                        System.out.println("--create");
                        newThread();
                    }
                    continue;
                }

                if (runnableQueue.size() > 0 && activeCount < maxSize)
                {
                    for (int i = coreSize; i < maxSize; i++)
                    {
                        newThread();
                    }
                }

                if (runnableQueue.size() == 0 && activeCount > coreSize)
                {
                    for (int i = coreSize; i < activeCount; i++)
                    {
                        removeThread();
                    }
                }
            }
        }
    }

    @Override
    public void shutdown()
    {
        synchronized (this)
        {
            if (isShutdown) return;
            isShutdown = true;
            threadQueue.forEach(threadTask ->
            {
                threadTask.internalTask.stop();
                threadTask.thread.interrupt();
            });
            this.interrupt();
        }
    }

    @Override
    public int getInitSize()
    {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.initSize;
    }

    @Override
    public int getMaxSize()
    {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.maxSize;
    }

    @Override
    public int getCoreSize()
    {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.coreSize;
    }

    @Override
    public int getQueueSize()
    {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return runnableQueue.size();
    }

    @Override
    public int getActiveCount()
    {
        synchronized (this)
        {
            return this.activeCount;
        }
    }

    @Override
    public boolean isShutdown()
    {
        return this.isShutdown;
    }

    private static class DefaultThreadFactory implements ThreadFactory
    {

        private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);

        private static final ThreadGroup group = new ThreadGroup("MyThreadPool-" + GROUP_COUNTER.getAndDecrement());

        private static final AtomicInteger COUNTER = new AtomicInteger(0);

        @Override
        public Thread createThread(Runnable runnable)
        {
            return new Thread(group, runnable, "thread-pool-" + COUNTER.getAndDecrement());
        }
    }

    /**
     * 线程和InternalTask 的组合，InternalTask实现Runnable，实现中就是不断的取任务队列里的任务来执行；
     * ThreadTask就是将InternalTask和具体哪个线程来执行的做一个组合
     */
    private static class ThreadTask
    {
        public ThreadTask(Thread thread, InternalTask internalTask)
        {
            this.thread = thread;
            this.internalTask = internalTask;
        }

        Thread thread;

        InternalTask internalTask;
    }
}