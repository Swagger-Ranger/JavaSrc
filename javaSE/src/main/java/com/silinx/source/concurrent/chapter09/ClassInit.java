package com.silinx.source.concurrent.chapter09;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/20
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class ClassInit
{
    static
    {
        try
        {
            System.out.println("The ClassInit static code block will be invoke.");
            TimeUnit.SECONDS.sleep(10);
            // 静态代码块只能对后面的变量进行赋值，但不能对其进行修改
            x = 12;
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static int x = 10;

    public static void main(String[] args)
    {
        IntStream.range(0, 5)
                .forEach(i -> new Thread(ClassInit::new));
    }
}
