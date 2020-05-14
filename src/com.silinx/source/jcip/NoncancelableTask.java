package com.silinx.source.jcip;

import java.util.concurrent.*;

/**
 * NoncancelableTask
 * <p/>
 * Noncancelable task that restores interruption before exit
 *
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "7.1.3", page = "118")
public class NoncancelableTask {

    /**
     * 不可取消的任务在退出前恢复中断：
     *     这里使用interrupt是无法钟断的，只能等while(true)中的代码自己跳出来，所以需要在catch中捕获中断
     *     状态保存在本地，并在结束后重新设置，这里就是finally中重新设置中断
     */

    //
    public Task getNextTask( BlockingQueue<Task> queue) {
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    interrupted = true;
                    // fall through and retry
                }
            }
        } finally {
            if (interrupted)
                Thread.currentThread().interrupt();
        }
    }

    interface Task {
    }
}
