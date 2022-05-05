package com.silinx.source.swaggerranger.mylib;

/**
 * cpu缓存命中测试 slow：5751273333，fast：350311875
 *
 * 原因cpu缓存是按行存储和读取
 * 首先来分析一下第一种情况，因为二维数组中的每一个数组对象占用的内存大小是512字节，而缓存行的大小是64字节，那么使用第一种遍历方式，
 * 假设当前遍历的数据是longs[i][j]，那么下一个遍历的数据是longs[i+1][j]，也就是说遍历的不是同一个数组对象，
 * 那么这两次遍历的数据肯定不在同一个缓存行内，也就是产生了Cache Miss；
 *
 * 在第二种情况中，假设当前遍历的数据是longs[i][j]，那么下一个遍历的数据是longs[i][j+1]，
 * 遍历的是同一个数组对象，所以当前的数据和下一个要遍历的数据可能都是在同一个缓存行中，这样发生Cache Miss的情况就大大减少了
 *
 */
public class L1CacheMiss {
    private static final int RUNS = 10;
    private static final int DIMENSION_1 = 1024 * 1024;
    private static final int DIMENSION_2 = 62;

    private static long[][] longs;

    public static void main(String[] args) throws Exception {
        longs = new long[DIMENSION_1][];
        for (int i = 0; i < DIMENSION_1; i++) {
            longs[i] = new long[DIMENSION_2];
        }
        System.out.println("starting....");

        final long start = System.nanoTime();
        long sum = 0L;
        for (int r = 0; r < RUNS; r++) {
            // 1. slow
//            for (int j = 0; j < DIMENSION_2; j++) {
//                for (int i = 0; i < DIMENSION_1; i++) {
//                    sum += longs[i][j];
//                }
//            }

            // 2. fast
            for (int i = 0; i < DIMENSION_1; i++) {
                for (int j = 0; j < DIMENSION_2; j++) {
                    sum += longs[i][j];
                }
            }
        }
        System.out.println("duration = " + (System.nanoTime() - start));
    }

    void i() {
        long l1 = 11883939677L;
        long l2 =  5751273333L;
        long l3 =   350311875L;
    }
}
