package com.silinx.source.jcip;

/**
 * PseudoRandom
 * 伪随机数生成器
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "15.3.2",page = "267")
public class PseudoRandom {
    int calculateNext(int prev) {
        prev ^= prev << 6;
        prev ^= prev >>> 21;
        prev ^= (prev << 7);
        return prev;
    }
}