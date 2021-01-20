package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ConcurrentUtils.FuturePattern;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Future
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/12 22:14
 * @Description: future设计模式的订单类
 * @Aha-eureka:
 *******************************************************************************/

public class Future {

    private Product product;

    //是否生产完成即对象是否已经构造出来了，用来协调get和set
    private boolean done;

    //这里使用同步，也就是当生产完成再唤醒获取线程
    public synchronized void setProduct( Product product ) {
        if (done) {
            return;
        }
        this.product = product;
        this.done = true;
        notifyAll();
    }

    //当get没有完成将done设为true时，线程等待
    public synchronized Product getProduct() {
        while (!done) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return product;

    }
}
