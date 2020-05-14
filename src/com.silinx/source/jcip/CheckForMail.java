package com.silinx.source.jcip;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**
 * CheckForMail
 * <p/>
 * Using a private \Executor whose lifetime is bounded by a method call
 *
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "7.2.4", page = "129")
public class CheckForMail {
    public boolean checkMail( Set<String> hosts, long timeout, TimeUnit unit)
            throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final AtomicBoolean hasNewMail = new AtomicBoolean(false);
        try {
            for (final String host : hosts)
                exec.execute(new Runnable() {
                    public void run() {
                        if (checkMail(host))
                            hasNewMail.set(true);
                    }
                });
        } finally {
            exec.shutdown();//不再接受请求
            exec.awaitTermination(timeout, unit);//阻止所有任务在结束后再次运行
        }
        return hasNewMail.get();
    }

    private boolean checkMail( String host) {
        // Check for mail
        return false;
    }
}
