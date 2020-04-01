package com.silinx.source.swaggerranger.JavaCore.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Reflection_Dynamic
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/6 22:58
 * @Description: 动态操作：构造器，方法和属性
 * @Aha-eureka:
 *******************************************************************************/

public class Reflection_Dynamic {

    static Class clazz;
    static{
        String path = "JavaCore.Reflection.User_Demo";
        try {
            clazz= Class.forName(path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void useReflection() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //这里newInstance实际就是在调用对于类的无参构造器，如果对于的类没有无参构造器则会抛出InstantiationException
        User_Demo demo = (User_Demo) clazz.newInstance();

        //使用特定的构造器新建对象
        Constructor constructor = User_Demo.class.getDeclaredConstructor(String.class, int.class);
        User_Demo demo1 = (User_Demo) constructor.newInstance("Swagger", 26);
        System.out.println(demo1);

        /**
         * 使用反射调用普通方法
         * 1.先获取到Class对象,并获取一个新的对象A
         * 2.然后通过Class对象获得方法对象Method
         * 3.使用Method.invoke(Object A，args...)方法调用类的方法
         */
        User_Demo A = (User_Demo) clazz.newInstance();
        Method method = clazz.getDeclaredMethod("setName", String.class);
        method.setAccessible(true);
        method.invoke(A, "Swagger1");
        System.out.println(A);

        /**
         * 通过反射操作属性
         *
         */
        User_Demo fDemo = (User_Demo) clazz.newInstance();
        Field f = clazz.getDeclaredField("name");
        f.setAccessible(true);//使用这个setAccessible(true)来设置可以访问私有方法和属性
        f.set(fDemo, "Ranger");//
        System.out.println(fDemo);
    }



    public static void main( String[] args ) {

        try {
            useReflection();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
