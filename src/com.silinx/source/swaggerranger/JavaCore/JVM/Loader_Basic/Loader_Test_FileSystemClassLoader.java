package com.silinx.source.swaggerranger.JavaCore.JVM.Loader_Basic;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Loader_Test_FileSystemClassLoader
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/8 0:40
 * @Description: 测试自定义的文件加载器
 * @Aha-eureka:
 *******************************************************************************/

public class Loader_Test_FileSystemClassLoader {

    public static void main( String[] args) throws Exception {
        FileSystemClassLoader loader = new FileSystemClassLoader("D:\\Swagger-Ranger\\git-workspace\\Algorithms\\src\\JavaCore\\JVM\\Loader_Basic");
        FileSystemClassLoader loader2 = new FileSystemClassLoader("D:\\Swagger-Ranger\\git-workspace\\Algorithms\\src\\JavaCore\\JVM\\Loader_Basic");

        Class<?> c = loader.loadClass("Loader_Demo");
        Class<?> c2 = loader.loadClass("Loader_Demo");
        Class<?> c3 = loader2.loadClass("Loader_Demo");

        Class<?> c4 = loader2.loadClass("java.lang.String");
        Class<?> c5 = loader2.loadClass("Loader_Demo");


        System.out.println(c.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());	//同一个类，被不同的加载器加载，JVM认为也是不相同的类
        System.out.println(c4.hashCode());
        System.out.println(c4.getClassLoader());	//引导类加载器
        System.out.println(c3.getClassLoader());	//自定义的类加载器
        System.out.println(c5.getClassLoader());	//系统默认的类加载器

    }

}
