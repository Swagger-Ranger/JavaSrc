package com.silinx.source.concurrent.chapter08;


/**
 * 这个 InternalTask 就相当于一个worker
 */
public class InternalTask implements Runnable
{

    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue)
    {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run()
    {
        /**
         * 这个内部工作worker会不断的去取任务队列里面的任务来执行
         */
        while (running && !Thread.currentThread().isInterrupted())
        {
            try
            {
                Runnable task = runnableQueue.take();
                task.run();

            } catch (InterruptedException e)
            {
                running = false;
                break;
            }
        }
    }

    public void stop()
    {
        this.running = false;
    }
}