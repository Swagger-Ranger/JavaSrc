package com.silinx.source.jcip;

import java.util.concurrent.atomic.*;

/**
 * XorShift
 *
 * 一个伪随机数生成器，
 *
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "12.1.3",page = "209")
public class XorShift {
    static final AtomicInteger seq = new AtomicInteger(8862213);
    int x = -1831433054;

    public XorShift(int seed) {
        x = seed;
    }

    public XorShift() {
        this((int) System.nanoTime() + seq.getAndAdd(129));
    }

    public int next() {
        x ^= x << 6;
        x ^= x >>> 21;
        x ^= (x << 7);
        return x;
    }
}
