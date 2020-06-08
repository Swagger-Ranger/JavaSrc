package com.silinx.source.jcip;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * LinkedQueue
 * <p/>
 * Insertion in the Michael-Scott nonblocking queue algorithm
 * 非阻塞链表--使用不加锁不同步的方式来构建并发链表
 * 链表和栈的不同在于，
 * 栈先进后出每个元素只指向一个元素且每个元素也只被一个元素所引用。
 * 而链表是先进先出需要单独维护头尾节点，同时有两个引用指向尾节点
 *
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "15.4.2", page = "272")
@ThreadSafe
public class LinkedQueue<E> {

    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        public Node( E item, Node<E> next ) {
            this.item = item;
            this.next = new AtomicReference<Node<E>>(next);
        }
    }

    private final Node<E> dummy = new Node<E>(null, null);

    /**
     * 在初始化的时候，头节点和尾节点都指向相同的守护节点，也就是当链表为空时始终存在一个守护节点
     */
    private final AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<Node<E>>(dummy);

    /**
     * 当插入节点的时候需要去更新两个节点，尾节点和链表的最后一个元素；所以这里需要针对两个节点更新导致可能出现不一致现象先进行处理
     * 这里解决多线程非阻塞并发访问共享变量的方法就是：每个线程在进行更新时都相互去检查中间状态将其他线程没有完成的中间状态完成，
     * 因为这里使用的是AtomicReference所以在更新引用时能保证可见性，同时在更新是使用CAS来保证原子性
     * @param item
     * @return
     */
    public boolean put( E item ) {
        Node<E> newNode = new Node<E>(item, null);
        while (true) {
            Node<E> curTail = tail.get();
            Node<E> tailNext = curTail.next.get();

            /**
             * curTail == tail.get()再次判断尾节点是否保存一致，否则就再去更新
             */
            if (curTail == tail.get()) {
                if (tailNext != null) {
                    /**
                     *  Queue in intermediate state, advance tail，如果出现中间状态，即其他线程将节点更新了一半，则帮助其他线程将尾节点向后更新
                     *  并再次进行检查，避免又有线程在更改链表，直到链表状态稳定再执行自己的操作
                     */
                    tail.compareAndSet(curTail, tailNext);
                } else {
                    // In quiescent state, try inserting new node 只有在稳定状态才去插入节点，同时要更新两个引用
                    if (curTail.next.compareAndSet(null, newNode))  {
                        // Insertion succeeded, try advancing tail
                        /**
                         * 这里如果tail.compareAndSet(curTail, newNode);失败不需要重试，因为失败只可能是另一个线程也在更改，
                         * 那么可以肯定另一个线程已经更改了所以直接返回
                         */
                        tail.compareAndSet(curTail, newNode);
                        return true;
                    }
                }
            }
        }
    }
}
