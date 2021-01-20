package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadCorrespondence.ProducerAndConsumer;

import java.util.concurrent.ConcurrentHashMap;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Test
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/10 15:50
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class Test {

    public static void main( String[] args ) {

        //Git test....

        //remote modify




//        Market market = new Market();
//        Market_Condition market = new Market_Condition();
        Market_BlockingQueue market = new Market_BlockingQueue();

        Producer p = new Producer(market);
        Consumer c = new Consumer(market);

        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();

        new Thread(c).start();
//        new Thread(c).start();
        new Thread(c).start();
        new Thread(c).start();

        new Thread(() -> market.size()).start();

    }
}
