package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Singleton;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: SingletonOfStarvation
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/5 14:15
 * @Description: 单例：饿汉式
 * @Aha-eureka:   饿汉单例模式不存在线程安全性问题，因为线程安全性问题的3个条件中，第3个对资源进行非原子性操作不满足，因为饿汉式
 *                  单例只是去访问单例
 *******************************************************************************/

public class SingletonOfStarvation {

    //私有化的构造函数
    private SingletonOfStarvation() { }

    private static SingletonOfStarvation instance = new SingletonOfStarvation();

    public static SingletonOfStarvation getInstance() {
        return instance;
    }


    public static void main( String[] args ) {
        //获取4个单例实例
        SingletonOfStarvation s1 = SingletonOfStarvation.getInstance();
        SingletonOfStarvation s2 = SingletonOfStarvation.getInstance();
        SingletonOfStarvation s3 = SingletonOfStarvation.getInstance();
        SingletonOfStarvation s4 = SingletonOfStarvation.getInstance();

        //可以看到所有的实例都是相同的hash值，即都是同一个对象
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
