package com.silinx.source.swaggerranger.JavaCore.JVM.Loader_Basic;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Loader_Demo
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/7 22:41
 * @Description: 类加载器示例
 * @Aha-eureka:
 *******************************************************************************/

public class Loader_Demo {

    public static void main( String[] args ) {
        /**
         * 1.8:sun.misc.Launcher$AppClassLoader@18b4aac2
         * 11:jdk.internal.loader.ClassLoaders$AppClassLoader@1f89ab83
         */
        System.out.println(ClassLoader.getSystemClassLoader());


        /**
         * 11:jdk.internal.loader.ClassLoaders$PlatformClassLoader@7f63425a
         */
        System.out.println(ClassLoader.getSystemClassLoader().getParent());

        System.out.println(System.getProperty("java.class.path"));

        /**
         * 自定义一个与JDK相同的类来测试,直接的结果就是不能执行：
         * 错误: 在类 JavaCore.JVM.Loader_Basic.Loader_Demo 中找不到 main 方法, 请将 main 方法定义为:
         *    public static void main(String[] args)
         * 否则 JavaFX 应用程序类必须扩展javafx.application.Application
         *
         * 原因：不会加载到这个类
         */
//        JavaCore.String a = new String();
//        System.out.println(a.getClass().getClassLoader());
//        System.out.println(a);

    }

}
