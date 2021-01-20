package com.silinx.source.swaggerranger.JavaCore.JVM.GC;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TestGC
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/11 15:08
 * @Description:  测试CMS GC，查看GC过程
 * @Aha-eureka:    IDEA配置运行参数VM options：-XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -Xms16m -Xmx16m
 *
 *                CMS将在JDK1.9之后移除，使用-Xlog:gc*来代替
 *Java HotSpot(TM) 64-Bit Server VM warning: Option UseConcMarkSweepGC was deprecated in version 9.0 and will likely be removed in a future release.
 * [0.009s][warning][gc] -XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead.
 *
 *[0.518s][info   ][gc,cpu         ] GC(7) User=0.03s Sys=0.00s Real=0.01s
 * [0.518s][info   ][gc,start       ] GC(8) Pause Initial Mark                <----初始标记
 * [0.519s][info   ][gc             ] GC(8) Pause Initial Mark 7M->7M(15M) 0.409ms
 * [0.519s][info   ][gc,cpu         ] GC(8) User=0.00s Sys=0.00s Real=0.00s
 * [0.519s][info   ][gc             ] GC(8) Concurrent Mark                   <---- 并发标记
 * [0.528s][info   ][gc             ] GC(8) Concurrent Mark 8.778ms
 * [0.528s][info   ][gc,cpu         ] GC(8) User=0.00s Sys=0.00s Real=0.01s
 * [0.528s][info   ][gc             ] GC(8) Concurrent Preclean               <----预处理
 * [0.528s][info   ][gc             ] GC(8) Concurrent Preclean 0.072ms
 * [0.528s][info   ][gc,cpu         ] GC(8) User=0.00s Sys=0.00s Real=0.00s
 * [0.528s][info   ][gc,start       ] GC(8) Pause Remark                      <----重新标记
 * [0.530s][info   ][gc             ] GC(8) Pause Remark 8M->8M(15M) 1.609ms
 * [0.530s][info   ][gc,cpu         ] GC(8) User=0.02s Sys=0.00s Real=0.00s
 * [0.530s][info   ][gc             ] GC(8) Concurrent Sweep                  <----并发清除
 * [0.533s][info   ][gc             ] GC(8) Concurrent Sweep 3.021ms
 * [0.533s][info   ][gc,cpu         ] GC(8) User=0.00s Sys=0.00s Real=0.00s
 * [0.533s][info   ][gc             ] GC(8) Concurrent Reset                  <----重置
 * [0.533s][info   ][gc             ] GC(8) Concurrent Reset 0.038ms
 * [0.533s][info   ][gc,cpu         ] GC(8) User=0.00s Sys=0.00s Real=0.00s
 * [0.533s][info   ][gc,heap        ] GC(8) Old: 7016K->7016K(10944K)
 * [0.599s][info   ][gc,start       ] GC(9) Pause Young (Allocation Failure)
 *******************************************************************************/

public class TestGC_CMS {

    public static void main( String[] args ) {
        TestGC.serialGC();
    }
}
