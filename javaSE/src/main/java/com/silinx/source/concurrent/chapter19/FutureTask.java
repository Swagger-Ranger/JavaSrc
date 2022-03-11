package com.silinx.source.concurrent.chapter19;

public class FutureTask<T> implements Future<T>
{

    private T result;

    private boolean isDone = false;

    private final Object LOCK = new Object();


    @Override
    public T get() throws InterruptedException
    {
        synchronized (LOCK)
        {
            while (!isDone)
            {
                LOCK.wait();
            }

            return result;
        }
    }

    protected void finish(T result)
    {
        synchronized (LOCK)
        {
            if (isDone)
                return;

            this.result = result;
            this.isDone = true;
            LOCK.notifyAll();
        }
    }

    @Override
    public boolean done()
    {
        return isDone;
    }
}