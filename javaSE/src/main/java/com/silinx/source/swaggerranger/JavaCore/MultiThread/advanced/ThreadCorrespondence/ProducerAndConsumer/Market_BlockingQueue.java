package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadCorrespondence.ProducerAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Market_BlockingQueue
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/13 22:00
 * @Description: 使用阻塞队列BlockingQueue的生产者消费者模型
 * @Aha-eureka:
 *******************************************************************************/

public class Market_BlockingQueue implements Market_Interface{

    private int product_count;
    private final int MAXIMUM = 10;

    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(MAXIMUM);


    @Override
    public void produce() {

        try {
            queue.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void consume() {

        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void size() {
        while (true) {
            System.out.println("当前队列长度为：" + queue.size());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
