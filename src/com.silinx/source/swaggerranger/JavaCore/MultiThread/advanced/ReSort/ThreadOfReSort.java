package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ReSort;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfReSort
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/18 9:35
 * @Description: 线程重排序
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfReSort {


    private int a;
    private int b;
    private int c;
    private boolean flag;


    public void a() {
        b = 2;
        a = 1;//这里a=1，和c=a的先后就会影响结果
        c = a;
        b = a + c;

        System.out.println(b);
    }


    public void writer( boolean flag ) {
        //这两行代码没有数据依赖性，所以处理器或者编译器可以对其进行重排序，但一旦重排序后就会直接影响下面的reader方法
        a = 2;
        this.flag = flag;
    }

    public void reader() {
        if (flag) {
            b = a + 1;
            System.out.println(b);//writer的重排序就可能导致b的数值不一致
        }
    }

    public static void main( String[] args ) {
        new ThreadOfReSort().a();

    }
}
