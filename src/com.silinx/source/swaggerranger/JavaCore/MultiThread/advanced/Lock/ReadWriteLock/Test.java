package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Lock.ReadWriteLock;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Test
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/9 15:39
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class Test {

    public static void main( String[] args ) {
        LockOfReadWrite lockOfReadWrite = new LockOfReadWrite();

        //写和写互斥
        /*new Thread(()->
            lockOfReadWrite.put("key-0", "value-0")
        ).start();

        new Thread(()->
            lockOfReadWrite.put("key-1", "value-1")
        ).start();

        new Thread(()->
            lockOfReadWrite.put("key-2", "value-2")
        ).start();
        */


        //写和写线程共享
        /*lockOfReadWrite.put("key-read", "value-read");
        new Thread(() -> lockOfReadWrite.get("key-read")).start();
        new Thread(() -> lockOfReadWrite.get("key-read")).start();
        new Thread(() -> lockOfReadWrite.get("key-read")).start();
        new Thread(() -> lockOfReadWrite.get("key-read")).start();
        new Thread(() -> lockOfReadWrite.get("key-read")).start();*/

        //写和读互斥
        new Thread(() -> lockOfReadWrite.put("key-read-write-0", "value-read-write-0")).start();
        new Thread(() -> lockOfReadWrite.get("key-read-write-0")).start();

        new Thread(() -> lockOfReadWrite.put("key-read-write-1", "value-read-write-1")).start();
        new Thread(() -> lockOfReadWrite.get("key-read-write-1")).start();

        new Thread(() -> lockOfReadWrite.put("key-read-write-2", "value-read-write-2")).start();
        new Thread(() -> lockOfReadWrite.get("key-read-write-2")).start();
        new Thread(() -> lockOfReadWrite.get("key-read-write-0")).start();

    }
}
