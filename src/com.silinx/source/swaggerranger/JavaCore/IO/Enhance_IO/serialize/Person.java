package com.silinx.source.swaggerranger.JavaCore.IO.Enhance_IO.serialize;

import java.io.Serializable;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Person
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/30 15:21
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    public Person( String name, int age ) {
        this.age = age;
        this.name = name;
    }

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge( int age ) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
