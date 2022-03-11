package com.silinx.source.concurrent.chapter22;

public class BalkingTest
{
    public static void main(String[] args)
    {
        new DocumentEditThread("G:\\", "balking.txt").start();
    }
}
