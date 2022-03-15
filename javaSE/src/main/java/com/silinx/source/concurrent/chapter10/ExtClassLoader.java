package com.silinx.source.concurrent.chapter10;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/20
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class ExtClassLoader
{
    public static void main(String[] args)
            throws ClassNotFoundException
    {
        System.out.println(System.getProperty("java.ext.dirs"));
        Class<?> helloClass = Class.forName("Hello");
        System.out.println(helloClass.getClassLoader());
    }
}
