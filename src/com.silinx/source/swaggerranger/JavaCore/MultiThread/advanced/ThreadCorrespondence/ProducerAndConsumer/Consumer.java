package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadCorrespondence.ProducerAndConsumer;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Consumer
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/10 15:49
 * @Description: 消费者
 * @Aha-eureka:
 *******************************************************************************/

public class Consumer implements Runnable {
    private Market_Interface market;

    Consumer( Market_Interface market ) {
        this.market = market;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            market.consume();
        }
    }
}
