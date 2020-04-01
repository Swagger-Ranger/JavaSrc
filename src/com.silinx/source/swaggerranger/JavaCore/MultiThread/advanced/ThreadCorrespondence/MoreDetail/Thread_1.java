package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadCorrespondence.MoreDetail;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Thread_1
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/10 0:59
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class Thread_1 implements Runnable {

    Wait_Notify_NotifyAll wnn;

    Thread_1( Wait_Notify_NotifyAll wnn ) {
        this.wnn = wnn;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wnn.setSignal();
    }
}
