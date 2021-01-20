package com.silinx.source.swaggerranger.JavaCore.JVM.GC;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TestGC
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/11 15:08
 * @Description:  测试并行GC，查看GC过程
 * @Aha-eureka:    IDEA配置运行参数VM options：-XX:+UseParallelGC -XX:+PrintGCDetails -Xms16m -Xmx16m
 *                -XX:+UseSerialGC 使用串行垃圾回收
 *                -XX:+PrintGCDetails 打印垃圾回收信息
 *                -Xms16m -Xmx16m  设置VM启动内存大小和最大内存大小
 *
 * [0.007s][warning][gc] -XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead.
 * [0.019s][info   ][gc] Using Parallel
 * [0.019s][info   ][gc,heap,coops] Heap address: 0x00000000ff000000, size: 16 MB, Compressed Oops mode: 32-bit
 * [0.301s][info   ][gc,start     ] GC(0) Pause Young (Allocation Failure)
 * [0.307s][info   ][gc,heap      ] GC(0) PSYoungGen: 4096K->496K(4608K)
 * [0.307s][info   ][gc,heap      ] GC(0) ParOldGen: 0K->1942K(11264K)
 * [0.307s][info   ][gc,metaspace ] GC(0) Metaspace: 6587K->6587K(1056768K)
 * [0.307s][info   ][gc           ] GC(0) Pause Young (Allocation Failure) 4M->2M(15M) 5.864ms
 * [0.307s][info   ][gc,cpu       ] GC(0) User=0.00s Sys=0.00s Real=0.01s
 * [0.444s][info   ][gc,start     ] GC(1) Pause Young (Allocation Failure)
 * [0.446s][info   ][gc,heap      ] GC(1) PSYoungGen: 4592K->486K(4608K)
 * [0.446s][info   ][gc,heap      ] GC(1) ParOldGen: 1942K->2710K(11264K)
 * [0.446s][info   ][gc,metaspace ] GC(1) Metaspace: 6588K->6588K(1056768K)
 * [0.446s][info   ][gc           ] GC(1) Pause Young (Allocation Failure) 6M->3M(15M) 2.579ms
 * [0.446s][info   ][gc,cpu       ] GC(1) User=0.00s Sys=0.00s Real=0.00s
 * [0.465s][info   ][gc,start     ] GC(2) Pause Young (Allocation Failure)
 * [0.471s][info   ][gc,heap      ] GC(2) PSYoungGen: 4582K->486K(4608K)
 * [0.471s][info   ][gc,heap      ] GC(2) ParOldGen: 2710K->5462K(11264K)
 * [0.471s][info   ][gc,metaspace ] GC(2) Metaspace: 6588K->6588K(1056768K)
 * [0.471s][info   ][gc           ] GC(2) Pause Young (Allocation Failure) 7M->5M(15M) 6.023ms
 * [0.471s][info   ][gc,cpu       ] GC(2) User=0.05s Sys=0.00s Real=0.01s
 * [0.479s][info   ][gc,start     ] GC(3) Pause Young (Allocation Failure)
 * [0.485s][info   ][gc,heap      ] GC(3) PSYoungGen: 4582K->498K(4608K)
 * [0.485s][info   ][gc,heap      ] GC(3) ParOldGen: 5462K->8182K(11264K)
 * [0.485s][info   ][gc,metaspace ] GC(3) Metaspace: 6588K->6588K(1056768K)
 * [0.485s][info   ][gc           ] GC(3) Pause Young (Allocation Failure) 9M->8M(15M) 5.818ms
 * [0.485s][info   ][gc,cpu       ] GC(3) User=0.03s Sys=0.02s Real=0.01s
 * [0.485s][info   ][gc,start     ] GC(4) Pause Full (Ergonomics)
 * [0.485s][info   ][gc,phases,start] GC(4) Marking Phase
 * [0.504s][info   ][gc,phases      ] GC(4) Marking Phase 19.619ms
 * [0.504s][info   ][gc,phases,start] GC(4) Summary Phase
 * [0.504s][info   ][gc,phases      ] GC(4) Summary Phase 0.014ms
 * [0.504s][info   ][gc,phases,start] GC(4) Adjust Roots
 * [0.506s][info   ][gc,phases      ] GC(4) Adjust Roots 1.660ms
 * [0.506s][info   ][gc,phases,start] GC(4) Compaction Phase
 * [0.528s][info   ][gc,phases      ] GC(4) Compaction Phase 21.543ms
 * [0.528s][info   ][gc,phases,start] GC(4) Post Compact
 * [0.528s][info   ][gc,phases      ] GC(4) Post Compact 0.060ms
 * [0.528s][info   ][gc,heap        ] GC(4) PSYoungGen: 498K->0K(4608K)
 * [0.528s][info   ][gc,heap        ] GC(4) ParOldGen: 8182K->7172K(11264K)
 * [0.528s][info   ][gc,metaspace   ] GC(4) Metaspace: 6588K->6588K(1056768K)
 * [0.528s][info   ][gc             ] GC(4) Pause Full (Ergonomics) 8M->7M(15M) 43.090ms
 * [0.528s][info   ][gc,cpu         ] GC(4) User=0.03s Sys=0.00s Real=0.04s
 * [0.606s][info   ][gc,start       ] GC(5) Pause Young (Allocation Failure)
 * [0.609s][info   ][gc,heap        ] GC(5) PSYoungGen: 4096K->512K(2560K)
 * [0.609s][info   ][gc,heap        ] GC(5) ParOldGen: 7172K->8780K(11264K)
 * [0.610s][info   ][gc,metaspace   ] GC(5) Metaspace: 6588K->6588K(1056768K)
 *******************************************************************************/

public class TestGC_Parallel {

    public static void main( String[] args ) {
        TestGC.serialGC();
    }
}
