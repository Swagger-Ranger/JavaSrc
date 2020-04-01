package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Prototype;

import java.io.*;
import java.util.Date;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: CloneTest
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/27 23:25
 * @Description: 测试深克隆和浅克隆，克隆就是重写Object父类的clone()方法
 * @Aha-eureka:  浅克隆是因为对象克隆只会克隆其引用并不会将其引用的对象也单独克隆，进而导致一个对象修改了引用的对象就会影响另一个对象
 *               深克隆就是将克隆对象引用的对象也克隆
 *
 *               测试结果：
 *
 * 浅克隆原对象修改影响了克隆的对象
 * JavaCore.DesignPattern.Prototype.Template_Shadow@5b464ce8
 * Fri Jan 02 18:17:36 CST 1970
 * swagger
 * Wed Sep 24 10:10:22 CST 2008
 * JavaCore.DesignPattern.Prototype.Template_Shadow@2cb4c3ab
 * Wed Sep 24 10:10:22 CST 2008 <----被影响了
 * Ranger
 * ----------------------------------
 * 深克隆则没有被影响
 * JavaCore.DesignPattern.Prototype.Template_Deep@12843fce
 * Fri Jan 02 18:17:36 CST 1970
 * swagger
 * Thu Nov 15 22:37:02 CST 1973
 * JavaCore.DesignPattern.Prototype.Template_Deep@3dd3bcd
 * Fri Jan 02 18:17:36 CST 1970 <----没有被影响
 * Ranger
 *******************************************************************************/

public class CloneTest {

    /**
     * 浅克隆，两个对象克隆实际指向的是同一个地址，修改会同时影响到两个对象
     */
    private static void shadowClone() {
        Date date = new Date(123456789L);

        Template_Shadow template = new Template_Shadow("swagger", date);
        System.out.println(template);
        System.out.println(template.getDate());
        System.out.println(template.getName());

        Template_Shadow template1 = null;
        try {
            template1 = (Template_Shadow) template.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //修改时间
        date.setTime(1222222222222L);
        System.out.println(template.getDate());

        template1.setName("Ranger");
        System.out.println(template1);
        System.out.println(template1.getDate());
        System.out.println(template1.getName());
    }

    private static void deepClone() {
        Date date = new Date(123456789L);

        Template_Deep template = new Template_Deep("swagger", date);
        System.out.println(template);
        System.out.println(template.getDate());
        System.out.println(template.getName());

        Template_Deep template1 = null;
        try {
            template1 = (Template_Deep) template.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //修改时间
        date.setTime(122222222222L);
        System.out.println(template.getDate());

        template1.setName("Ranger");
        System.out.println(template1);
        System.out.println(template1.getDate());
        System.out.println(template1.getName());
    }


    private static void deepClone_Serialize() {

        Date date = new Date(123456789L);

        Template_Deep template_source = new Template_Deep("swagger", date);
        System.out.println(template_source + "\n" + template_source.getDate() + "\n" + template_source.getName());

        Template_Deep template_target = null;
        byte[] bytes = null;

        //将对象序列化到一个数组
        try (
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        ) {

            objectOutputStream.writeObject(template_source);
            bytes = byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //将对象从数组中读出来
        try (
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)
        ) {
            template_target = (Template_Deep) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //修改时间来测试是否受到影响
        date.setTime(122222222222L);
        System.out.println(template_source.getDate());

        template_target.setName("Ranger");
        System.out.println(template_target);
        System.out.println(template_target.getDate());
        System.out.println(template_target.getName());

    }


    public static void main( String[] args ) {

        shadowClone();
        System.out.println("----------------------------------");
        deepClone();
        System.out.println("===================================");
        deepClone_Serialize();

    }
}
