package com.silinx.source.concurrent.chapter27.type1;

import java.util.LinkedList;

/***************************************
 * @author:Alex Wang
 * @Date:2017/12/5
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class ActiveMessageQueue
{
    private final LinkedList<MethodMessage> messages = new LinkedList<>();

    public ActiveMessageQueue()
    {
        new ActiveDaemonThread(this).start();
    }

    public void offer(MethodMessage activeMessage)
    {
        synchronized (this)
        {
            messages.addLast(activeMessage);
            this.notify();
        }
    }

    public MethodMessage take()
    {
        synchronized (this)
        {
            while (messages.isEmpty())
            {
                try
                {
                    this.wait();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            return messages.removeFirst();
        }
    }
}