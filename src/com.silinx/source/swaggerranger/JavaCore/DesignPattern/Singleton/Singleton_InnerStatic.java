package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Singleton;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Singleton_InnerStatic
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/25 23:44
 * @Description: 静态内部类实现单例
 * @Aha-eureka:
 *******************************************************************************/

public class Singleton_InnerStatic {

    private Singleton_InnerStatic() {
        //可以看到在调用Singleton_InnerStatic()方法时才会打印这个语句
        System.out.println("3333333333333333333333333");
    }
    /**
     * 定义静态内部类：
     *   final保证只会被赋值一次
     *   static保证内存中只有一个实例存在
     */
    private static class SingletonInstance {
        private static final Singleton_InnerStatic instance = new Singleton_InnerStatic();
    }


    /**
     * 调用此方法时才会去加载内部类，进而实现懒加载
     * @return
     */
    public static Singleton_InnerStatic getInstance() {
        return SingletonInstance.instance;
    }

    public static void main( String[] args ) {
        System.out.println("---------22222");
        Singleton_InnerStatic.getInstance();
    }

}
