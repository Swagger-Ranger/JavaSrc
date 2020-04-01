package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Singleton;

import java.io.*;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: SingletonOfIdler
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/5 14:26
 * @Description: 懒汉式单例模式
 * @Aha-eureka:  懒汉式单例模式存在线程安全性问题，因为实例化并不是原子性操作
 *******************************************************************************/

public class SingletonOfIdler implements Serializable {

    private static volatile SingletonOfIdler instance;

    private SingletonOfIdler() {
        //防止通过反射来破坏单例
        if (instance != null) throw new RuntimeException("Singleton have existed!");
    }


    /**
     * 防止通过序列化（即先将对象写入文件，然后再从文件中读出对象，单读出的对象是个新建的对象）破坏单例
     * 如果定义了readResolve()方法则直接返回此方法指定的对象，而不需要单独创建新对象
     * 这个方法需要和implements Serializable 对应，如果不实现序列化则用不到这个
     */
    private Object readResolve() throws ObjectStreamException { return instance; }


    //不加线程安全的操作
    /*public static SingletonOfIdler getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingletonOfIdler();
        }

        return instance;
    }*/

    //不考虑性能的线程安全的操作，直接使用synchronized 修饰符
    /*public static synchronized SingletonOfIdler getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingletonOfIdler();
        }

        return instance;
    }*/

    /**
     * 考虑性能和线程安全性的更好的实现
     * 对块加锁，这样可以避免每次都要去获取锁，因为这个单例中只有实例化时会出现安全性操作
     * 同时对私有变量instance 加volatile修饰符，避免因为jvm优化中指令重排序（即虚机对代码进行优化，
     * 可能后面的代码先于前面的代码执行）而导致在双重检验加锁中出现检验出错而导致线程安全问题
     * 双重检验加锁
     * @return
     */
    public static SingletonOfIdler getInstance() {

        if (instance == null) {
            synchronized (SingletonOfIdler.class) {
                //双重检验加锁
                if (instance == null) {
                    instance = new SingletonOfIdler();
                }
            }
        }

        return instance;
    }

    public static void main( String[] args ) {
        //下面打印都是相同的hash值，但并不代表就没有线程安全性问题
        /**
         * 在MultiThreadTestOfSingleton.java的测试中结果如下
         * pool-1-thread-1:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6c526acc
         * pool-1-thread-2:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6a1ebbc--->这里就出现了线程安全性问题
         * pool-1-thread-2:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6c526acc
         * pool-1-thread-1:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6c526acc
         * pool-1-thread-2:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6c526acc
         * pool-1-thread-1:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6c526acc
         * pool-1-thread-2:JavaCore.MultiThread.advanced.Singleton.SingletonOfIdler@6c526acc
         */
        SingletonOfIdler s1 = SingletonOfIdler.getInstance();
        System.out.println(s1);

        //序列化测试
        try (
                FileOutputStream fos = new FileOutputStream("D:\\Swagger-Ranger\\a.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Swagger-Ranger\\a.txt"))
        ) {
            oos.writeObject(s1);
            SingletonOfIdler s5 = (SingletonOfIdler) ois.readObject();
            System.out.println(s5);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
