package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.AtomicClass;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: User
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/7 23:29
 * @Description: 原子类操作抽象类的示例类
 * @Aha-eureka:
 *******************************************************************************/

public class User {

    private volatile String name;

    public volatile int age;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge( int age ) {
        this.age = age;
    }
}
