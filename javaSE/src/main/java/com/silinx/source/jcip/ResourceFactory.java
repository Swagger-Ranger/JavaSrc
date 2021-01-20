package com.silinx.source.jcip;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ResourceFactory
 * <p/>
 * Lazy initialization holder class idiom
 * 安全的初始化模式
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "16.2.3", page = "285")
@ThreadSafe
public class ResourceFactory {
    private static class ResourceHolder {
        public static Resource resource = new Resource();
    }

    public static Resource getResource() {
        return ResourceHolder.resource;
    }

    static class Resource {
    }

    public static void main( String[] args ) {
        ReentrantLock re = new ReentrantLock();
//        ReentrantLock
//        AbstractQueuedSynchronizer
    }
}
