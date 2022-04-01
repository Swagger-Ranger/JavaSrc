package com.silinx.source.concurrent.chapter27.type1;

class ActiveDaemonThread extends Thread
{
    private final ActiveMessageQueue queue;

    public ActiveDaemonThread(ActiveMessageQueue queue)
    {
        super("ActiveDaemonThread");
        this.queue = queue;
        setDaemon(true);
    }

    @Override
    public void run()
    {
        for (; ; )
        {
            MethodMessage activeMessage = this.queue.take();
            activeMessage.execute();
        }
    }
}