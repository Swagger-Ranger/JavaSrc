package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Prototype;

import java.io.Serializable;
import java.util.Date;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Template_Shadow
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/27 23:20
 * @Description: 深克隆模板对象--深克隆就是将克隆对象的属性也克隆
 * @Aha-eureka:  深克隆有两种方式，一是在重写clone()方法时将引用的对象也再作克隆；
 *                                另一种方式就是实现序列化接口然后在克隆的调用端使用序列化来克隆
 *******************************************************************************/

public class Template_Deep implements Cloneable, Serializable {

    private String name;
    private Date date;

    public Template_Deep() { }
    public Template_Deep( String name, Date date ) {
        this.name = name;
        this.date = date;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();

        //这里实现深克隆
        Template_Deep template_deep = (Template_Deep) obj;
        template_deep.date = (Date) this.date.clone();

        return obj;
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
