package com.silinx.source.jcip;

import java.util.concurrent.locks.*;

/**
 * InterruptibleLocking
 *
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "13.1.1",page = "230")
public class InterruptibleLocking {
    private Lock lock = new ReentrantLock();

    public boolean sendOnSharedLine( String message)
            throws InterruptedException {
        lock.lockInterruptibly();
        try {
            return cancellableSendOnSharedLine(message);
        } finally {
            lock.unlock();
        }
    }

    private boolean cancellableSendOnSharedLine( String message) throws InterruptedException {
        /* send something */
        return true;
    }

}
