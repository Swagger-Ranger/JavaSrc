package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadCorrespondence.ProducerAndConsumer;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Market
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/10 15:31
 * @Description: 生产者消费者模型地市场，即生成者与消费者线程通信地中间类
 * @Aha-eureka:
 *******************************************************************************/

public class Market implements Market_Interface{

    private int product_count;
    private final int MAXIMUM = 10;

    public synchronized void produce() {

        //注意这里判断库存情况必须用while而不能用if，在唤醒后while将继续判断直到不满足即小于库存容量才会生产，而if不会再次去判断库存就直接生产
        while (this.product_count >= MAXIMUM) {
            System.out.println("库存饱和，生产者: " + Thread.currentThread().getName() + ",请停止生产...");

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product_count++;
        System.out.println("生产者： " + Thread.currentThread().getName() + "生成并推送到库存,当前库存：" + product_count);
        notifyAll();
    }

    public synchronized void consume() {
        while (this.product_count <= 0) {
            System.out.println("库存告罄，消费者：" + Thread.currentThread().getName() + "正在等待，请生产者开始生产...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        product_count--;
        System.out.println("消费者：" + Thread.currentThread().getName() + "消费成功,当前库存：" + product_count);
        notifyAll();
    }
}
