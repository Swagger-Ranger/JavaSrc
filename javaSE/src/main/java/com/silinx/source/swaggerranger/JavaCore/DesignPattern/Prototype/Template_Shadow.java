package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Prototype;

import java.util.Date;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Template_Shadow
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/27 23:20
 * @Description: 浅克隆模板对象
 * @Aha-eureka:
 *******************************************************************************/

public class Template_Shadow implements Cloneable {

    private String name;
    private Date date;

    public Template_Shadow() { }
    public Template_Shadow( String name, Date date ) {
        this.name = name;
        this.date = date;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate( Date date ) {
        this.date = date;
    }
}
