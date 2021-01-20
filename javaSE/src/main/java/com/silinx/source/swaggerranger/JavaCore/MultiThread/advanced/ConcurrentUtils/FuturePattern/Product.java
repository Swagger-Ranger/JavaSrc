package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ConcurrentUtils.FuturePattern;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Product
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/12 22:24
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class Product {

    private String name;
    private int id;

    public Product( int id, String name ) {
        System.out.println("开始生产 " + name);
        try {
            //线程等待模拟耗时较长任务
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.id = id;
        this.name = name;
        System.out.println(name + "生产完成");
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
