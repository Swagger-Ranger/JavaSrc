package com.silinx.source.jcip;

import net.jcip.annotations.*;

/**
 * GrumpyBoundedBuffer
 * <p/>
 * Bounded buffer that balks when preconditions are not met
 * 如果不满足条件，有界队列不会做任何操作，但这不是一个好的实现。不满足条件就直接抛出异常，但实际上不满足条件并没有是问题
 *
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "14.1.1", page = "240")
@ThreadSafe
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    public GrumpyBoundedBuffer() {
        this(100);
    }

    public GrumpyBoundedBuffer( int size ) {
        super(size);
    }

    public synchronized void put( V v ) throws BufferFullException {
        if (isFull())
            throw new BufferFullException();
        doPut(v);
    }

    public synchronized V take() throws BufferEmptyException {
        if (isEmpty())
            throw new BufferEmptyException();
        return doTake();
    }
}

class ExampleUsage {
    private GrumpyBoundedBuffer<String> buffer;
    int SLEEP_GRANULARITY = 50;

    void useBuffer() throws InterruptedException {
        while (true) {
            try {
                String item = buffer.take();
                // use item
                break;
            } catch (BufferEmptyException e) {
                Thread.sleep(SLEEP_GRANULARITY);
            }
        }
    }
}

class BufferFullException extends RuntimeException {
}

class BufferEmptyException extends RuntimeException {
}
