package com.silinx.source.lambdasinaction.chap14;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2020,github:Swagger-Ranger </p>
 * <p>@FileName:    CloneTest </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2020/1/16 18:50 </p>
 * <p>@Description:  </p>
 * <p>@Aha-eureka: </p>
 ******************************************************************************/

public class CloneTest implements Cloneable{

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public CloneTest(int id, String name) {
        this.id = id;
        this.name = name;
    }


    void yell() {
        System.out.println("---------CloneTest------------");

    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest cloneTest = new CloneTest(1, "haha");
        CloneTest cloneTest1 = (CloneTest) cloneTest.clone();
        cloneTest1.setId(2);

        CloneTest cloneTest2 = (CloneTest) cloneTest1.clone();
        cloneTest2.setId(3);

        CloneTest cloneTest3 = cloneTest;
        System.out.println(cloneTest1.id);
        System.out.println(cloneTest2.id);
        System.out.println(cloneTest3.id);
        System.out.println(cloneTest == cloneTest1);
        System.out.println(cloneTest == cloneTest3);
        System.out.println(cloneTest1 == cloneTest2);


    }
}
