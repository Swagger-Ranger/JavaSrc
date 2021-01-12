package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadCorrespondence.ProducerAndConsumer;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Producer
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/10 15:48
 * @Description: 生产者
 * @Aha-eureka:
 *******************************************************************************/

public class Producer implements Runnable {
    private Market_Interface market;

    Producer( Market_Interface market ) {
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

            market.produce();

        }
    }
}
