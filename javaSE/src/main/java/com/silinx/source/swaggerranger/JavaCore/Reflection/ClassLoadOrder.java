package com.silinx.source.swaggerranger.JavaCore.Reflection;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ClassLoadOrder
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/6 23:44
 * @Description: 类加载顺序
 * @Aha-eureka:   1、父类静态变量和静态代码块（先声明的先执行）；
 *                2、子类静态变量和静态代码块（先声明的先执行）；
 *                3、父类的变量和代码块（先声明的先执行）；
 *                4、父类的构造函数；
 *                5、子类的变量和代码块（先声明的先执行）；
 *                6、子类的构造函数。
 *******************************************************************************/

public class ClassLoadOrder extends ClassLoadOrder_Super{

    //private static ClassLoadOrder instance = new ClassLoadOrder();
    private static Other instance = new Other();
    static {
        System.out.println(ClassLoader.class.getSimpleName() + " : static{}");
    }


    {
        System.out.println("no static");
    }

    public ClassLoadOrder() {
        System.out.println(ClassLoadOrder.class.getSimpleName() + " : Constuctor with this = " + this);
    }


    public static void main( String[] args ) {
        System.out.println("----------------------------------");
        ClassLoadOrder classLoadOrder = new ClassLoadOrder();
    }
}

class Other {
    static { System.out.println("Other------------------"); }
}

class ClassLoadOrder_Super {
    static {
        System.out.println(ClassLoadOrder_Super.class.getSimpleName() + " : static{}");
    }
    private static Other instance = new Other();

    {
        System.out.println("no static");
        int m = 0;
        System.out.println("no static m: " + ++m);
    }

    ClassLoadOrder_Super() {
        System.out.println(ClassLoadOrder_Super.class.getSimpleName() + " : Constuctor with super = " + this);
    }
}
