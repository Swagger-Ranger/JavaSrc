package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced;

import java.util.Timer;
import java.util.TimerTask;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfTimer
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/4 15:37
 * @Description: 线程的定时器
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfTimer {

    public static void main( String[] args ) {
        Timer timer = new Timer();

        //TimerTask也是一个实现了Runnable接口的类，这里的参数0是延迟多少时间执行，1000是间隔多少时间再次执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //需要实现的定时任务
                System.out.println("Timer tick tick tick...");
            }
        },0,1000);
    }


}
