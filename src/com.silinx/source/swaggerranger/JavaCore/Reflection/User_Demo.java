package com.silinx.source.swaggerranger.JavaCore.Reflection;

import java.util.ArrayList;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: User_Demo
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/6 19:13
 * @Description: User工具类
 * @Aha-eureka:
 *******************************************************************************/

public class User_Demo {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    private void setName( String name ) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge( int age ) {
        this.age = age;
    }

    public User_Demo() { }

    public User_Demo( String name, int age ) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User_Demo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main( String[] args ) throws ClassNotFoundException {
//        User_Demo demo = new User_Demo();
//        demo.setAge(7);
//        demo.setName("swagger");
//
////        Class clazz = Class.forName(String.valueOf(demo.getClass()));
//        Class clazz = Class.forName(demo.getClass().getName());
//
//        System.out.println(clazz.getClass().getDeclaredFields().length);

        List<String> list = new ArrayList<>();
        list.add(null);
        System.out.println(list.size());
        list.add(null);

        System.out.println(list.size());

    }
}
