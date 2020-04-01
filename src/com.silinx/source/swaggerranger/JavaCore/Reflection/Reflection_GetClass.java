package com.silinx.source.swaggerranger.JavaCore.Reflection;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Reflection_GetClass
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/6 19:11
 * @Description: 获取Class对象
 * @Aha-eureka:  Class类是Reflection反射的基础，任何要动态加载，运行的类，都必须先获得对于的Class对象
 *******************************************************************************/

public class Reflection_GetClass {

    public static void main( String[] args ) throws ClassNotFoundException {
        String path = "JavaCore.Reflection.User_Demo";

        //获取Class的几种方式
        {
            //一个类只有一个Class对象
            Class clazz1 = Class.forName(path);
            Class clazz11= Class.forName(path);

            System.out.println(clazz1.hashCode());//相同hashcode
            System.out.println(clazz11.hashCode());//相同hashcode
        }

        {
            User_Demo user_demo = new User_Demo();
            Class clazz2 = user_demo.getClass();

            Class clazz3 = User_Demo.class;

            System.out.println(clazz2 == clazz3);//true
            System.out.println(clazz2.hashCode());

        }

        int[] arr0 = new int[5];
        int[] arr01 = new int[15];
        long[] arr02 = new long[15];
        int[][] arr1 = new int[5][5];

        System.out.println(arr0.getClass() + "   " + arr0.getClass().hashCode());//class [I   920011586
        System.out.println(arr01.getClass() + "   " + arr01.getClass().hashCode());//class [I   920011586
        System.out.println(arr02.getClass() + "   " + arr02.getClass().hashCode());//class [J   2017354584
        System.out.println(arr1.getClass() + "   " + arr1.getClass().hashCode());//class [[I   2017354584

    }

}
