package com.silinx.source.swaggerranger.JavaCore.MultiThread.introduction;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfAnonymousInnerClass
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/4 15:04
 * @Description: 通过匿名内部类来创建线程,当一个线程只使用一次是，可以直接使用匿名内部类来简洁的实现
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfAnonymousInnerClass {

    static volatile int num = 0;


    /**
     * 这里使用了两种方法来实现，注意：如果我们同时使用两个呢？即又传入接口实现又重新子类run()，那么会执行哪个的run方法内容呢
     * 答案是子类的run方法，因为，传入接口实现执行的是父类的run方法，只不过在run方法中的target替换成了我们的run方法实现
     * 而当子类重写run方法是，在子类中肯定是执行子类的run方法啊。这个问题其实就是看Thread的run方法具体底层是如何实现的
     * @param args
     */
    public static void main( String[] args ) {

        //通过实现Thread的run方法实现
//        new Thread(() -> System.out.println(" anonymousInner Thread of run() started!...")).start();
//        new Thread(() -> ThreadExcep.throwExecption()).start();



        //通过向Thread传入Runnable接口实现来实现
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(" anonymousInner Thread of Runnable started!...");
//            }
//        }).start();


        for (int i = 0; i < 10; i++) {
            run();
        }
    }

    public static void run() {
        new Thread(() -> {
            num++;
            try {
                ThreadExcep.waiting();
            } catch (InterruptedException e) {
                System.out.println("exception");
            }
        }).start();

        System.out.println("ssssssssssssssssssss" + num);
    }
}
