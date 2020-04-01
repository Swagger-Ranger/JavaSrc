package com.silinx.source.swaggerranger.JavaCore.JVM.GC;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: TestGC
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/11 15:08
 * @Description:  测试串行GC，查看GC过程
 * @Aha-eureka:    IDEA配置运行参数VM options：-XX:+UseSerialGC -XX:+PrintGCDetails -Xms16m -Xmx16m
 *                -XX:+UseSerialGC 使用串行垃圾回收
 *                -XX:+PrintGCDetails 打印垃圾回收信息
 *                -Xms16m -Xmx16m  设置VM启动内存大小和最大内存大小
 *
 *
 * [0.009s][warning][gc] -XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead.
 * [0.022s][info   ][gc] Using Serial
 * [0.022s][info   ][gc,heap,coops] Heap address: 0x00000000ff000000, size: 16 MB, Compressed Oops mode: 32-bit
 * [0.308s][info   ][gc,start     ] GC(0) Pause Young (Allocation Failure)     <---- Pause Young (Allocation Failure) 开始年轻代GC，不包括年老代，GC原因Allocation Failure内存分配失败，即内存耗光，本身设置16M，年轻代分配的肯定就更小
 * [0.316s][info   ][gc,heap      ] GC(0) DefNew: 4416K->512K(4928K)           <---- DefNew：开始串行回收，4416k开始回收时占用内存，512k回收后占用内存，4928k总共内存
 * [0.316s][info   ][gc,heap      ] GC(0) Tenured: 0K->2100K(10944K)           <---- 可以看出回收前占用0，回收后占用2100k，有年轻代的对象被放入了年老代
 * [0.316s][info   ][gc,metaspace ] GC(0) Metaspace: 6580K->6580K(1056768K)    <---- 在这个GC过程中没有动方法区中的对象
 * [0.316s][info   ][gc           ] GC(0) Pause Young (Allocation Failure) 4M->2M(15M) 8.220ms
 * [0.317s][info   ][gc,cpu       ] GC(0) User=0.02s Sys=0.00s Real=0.01s
 * [0.340s][info   ][gc,start     ] GC(1) Pause Young (Allocation Failure)
 * [0.349s][info   ][gc,heap      ] GC(1) DefNew: 4928K->512K(4928K)
 * [0.349s][info   ][gc,heap      ] GC(1) Tenured: 2100K->5016K(10944K)
 * [0.349s][info   ][gc,metaspace ] GC(1) Metaspace: 6580K->6580K(1056768K)
 * [0.349s][info   ][gc           ] GC(1) Pause Young (Allocation Failure) 6M->5M(15M) 8.863ms
 * [0.349s][info   ][gc,cpu       ] GC(1) User=0.02s Sys=0.00s Real=0.01s
 * [0.454s][info   ][gc,start     ] GC(2) Pause Young (Allocation Failure)
 * [0.460s][info   ][gc,heap      ] GC(2) DefNew: 4928K->512K(4928K)
 * [0.460s][info   ][gc,heap      ] GC(2) Tenured: 5016K->7894K(10944K)
 * [0.460s][info   ][gc,metaspace ] GC(2) Metaspace: 6580K->6580K(1056768K)
 * [0.460s][info   ][gc           ] GC(2) Pause Young (Allocation Failure) 9M->8M(15M) 6.236ms
 * [0.460s][info   ][gc,cpu       ] GC(2) User=0.02s Sys=0.00s Real=0.01s
 * ......
 * [0.904s][info   ][gc,cpu         ] GC(7) User=0.00s Sys=0.00s Real=0.00s
 * [1.057s][info   ][gc,start       ] GC(8) Pause Young (Allocation Failure)
 * [1.057s][info   ][gc,start       ] GC(9) Pause Full (Allocation Failure) <----Pause Full (Allocation Failure) 内存分配失败，所有内存空间开始全部GC,即包括老年代
 * [1.057s][info   ][gc,phases,start] GC(9) Phase 1: Mark live objects      <----可以看出采用了压缩标记法，先标记存活的对象
 * [1.061s][info   ][gc,phases      ] GC(9) Phase 1: Mark live objects 3.279ms
 * [1.061s][info   ][gc,phases,start] GC(9) Phase 2: Compute new object addresses  <----计算内存大小
 * [1.064s][info   ][gc,phases      ] GC(9) Phase 2: Compute new object addresses 3.114ms
 * [1.064s][info   ][gc,phases,start] GC(9) Phase 3: Adjust pointers      <----调整内存引用
 * [1.066s][info   ][gc,phases      ] GC(9) Phase 3: Adjust pointers 2.074ms
 * [1.066s][info   ][gc,phases,start] GC(9) Phase 4: Move objects         <----移动对象
 * [1.067s][info   ][gc,phases      ] GC(9) Phase 4: Move objects 0.777ms
 * [1.067s][info   ][gc             ] GC(9) Pause Full (Allocation Failure) 13M->3M(15M) 9.637ms
 * [1.067s][info   ][gc,heap        ] GC(8) DefNew: 4928K->0K(4928K)
 * [1.067s][info   ][gc,heap        ] GC(8) Tenured: 8674K->3340K(10944K)
 * ......
 * [2.327s][info   ][gc             ] GC(16) Pause Young (Allocation Failure) 8M->6M(15M) 3.350ms
 * [2.327s][info   ][gc,cpu         ] GC(16) User=0.00s Sys=0.00s Real=0.00s
 * [2.537s][info   ][gc,start       ] GC(17) Pause Young (Allocation Failure)
 * [2.547s][info   ][gc,heap        ] GC(17) DefNew: 4928K->511K(4928K)
 * [2.547s][info   ][gc,heap        ] GC(17) Tenured: 6636K->8563K(10944K)
 * [2.547s][info   ][gc,metaspace   ] GC(17) Metaspace: 7493K->7493K(1056768K)  <-------注意：Metaspace方法区的内存空间几乎一致没变，因为其存放的是类的结果，不是对象，且其空间在JDK1.8之后也不在VM内存中
 *                                                                                      而是在服务器内存中，其内存大小是可以动态变化的
 * ......
 *******************************************************************************/

public class TestGC {

    public static void main( String[] args ) {
        serialGC();
    }

    public static void serialGC() {
        List<Object> list = new ArrayList<>();
        while (true) {
            int sleep = new Random().nextInt(100);
            if (System.currentTimeMillis() % 2 == 0) {
                list.clear();
            } else {
                for (int i = 0; i < 10000; i++) {
                    Properties properties = new Properties();
                    properties.put("key_" + i, "value_" + System.currentTimeMillis() + i);
                    list.add(properties);
                }
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
