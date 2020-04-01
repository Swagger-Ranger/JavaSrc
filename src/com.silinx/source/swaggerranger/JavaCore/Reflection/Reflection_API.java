package com.silinx.source.swaggerranger.JavaCore.Reflection;

import java.lang.reflect.Constructor;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Reflection_API
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/6 22:09
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class Reflection_API {

    public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException {
        String path = "JavaCore.Reflection.User_Demo";

        Class clazz1 = Class.forName(path);

        //获取类的名字
        Constructor constructor = clazz1.getConstructor();
        Constructor constructor2 = clazz1.getConstructor(String.class, int.class);
        System.out.println(constructor);
        System.out.println(constructor2);

    }
}
