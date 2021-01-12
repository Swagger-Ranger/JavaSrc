package com.silinx.source.swaggerranger.JavaCore.Serializable;

import java.io.Serializable;

//@Data
public class User implements Serializable {

    private static final long serialVersionUID = -6665803513692325794L;

    //年龄
    private int age;
    //名字
    private String name ;

    private Integer sex;



    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}