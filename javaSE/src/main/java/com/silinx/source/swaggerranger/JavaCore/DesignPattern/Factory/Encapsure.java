package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Factory;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Encapsure
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/27 15:11
 * @Description: 一个文件里多个class类
 * @Aha-eureka:
 *******************************************************************************/

public class Encapsure {

}

class A {
    String name;

    public A( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
}