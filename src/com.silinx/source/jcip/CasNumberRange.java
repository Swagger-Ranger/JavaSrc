package com.silinx.source.jcip;

import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CasNumberRange
 * <p/>
 * Preserving multivariable invariants using CAS
 * 维护多个可变的变量，同时保证其在同时更新多个值是仍然保存正确行
 *  使用AtomicReference在内部维护一个不可变static  的静态内部类final其属性，然后在后面更新时返回一个新的内部类对象。
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "15.3.1", page = "267")
@ThreadSafe
public class CasNumberRange {
    @Immutable
    private static class IntPair {
        // INVARIANT: lower <= upper
        final int lower;
        final int upper;

        public IntPair( int lower, int upper ) {
            this.lower = lower;
            this.upper = upper;
        }
    }

    private final AtomicReference<IntPair> values =
            new AtomicReference<IntPair>(new IntPair(0, 0));

    public int getLower() {
        return values.get().lower;
    }

    public int getUpper() {
        return values.get().upper;
    }

    public void setLower( int i ) {
        while (true) {
            IntPair oldv = values.get();
            if (i > oldv.upper)
                throw new IllegalArgumentException("Can't set lower to " + i + " > upper");
            IntPair newv = new IntPair(i, oldv.upper);
            if (values.compareAndSet(oldv, newv))
                return;
        }
    }

    public void setUpper( int i ) {
        while (true) {
            IntPair oldv = values.get();
            if (i < oldv.lower)
                throw new IllegalArgumentException("Can't set upper to " + i + " < lower");
            IntPair newv = new IntPair(oldv.lower, i);
            if (values.compareAndSet(oldv, newv))
                return;
        }
    }
}
