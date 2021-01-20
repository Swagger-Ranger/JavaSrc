package com.silinx.source.algs4.Chapter1.chapter1_1;

import com.silinx.source.algs4.algs4_lib.StdOut;
import com.silinx.source.algs4.algs4_lib.StdRandom;

public class Ex_1_1_36
{
    public interface IShuffle  //内部接口，将打乱的具体方式，也就是使用什么算法来打乱数组留给实现者
    {
        public void shuffle( int[] a );     //打乱的方法

    }
// 大小为M，打乱次数为N
    public static void ShuffleTest(IShuffle shuffle, int m, int n)
    {
        int[][] s = new int[m][m];
        
        for (int k = 0; k < n; k++) //执行每次的打乱操作
        {
            int[] a = new int[m];
            for (int i = 0; i < m; i++) //执行重置操作
                a[i] = i;
            
            shuffle.shuffle(a);
            
            for (int i = 0; i < m; i++)
                s[i][a[i]]++;   //执行计数操作  数i被打乱后落在j列（a[1])的次数
        }
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < m; j++)
                StdOut.printf("%7d", s[i][j]);
            StdOut.println();
        }
    }
    
    public static void main( String[] args)
    {
//        int m = Integer.parseInt(args[0]);
//        int n = Integer.parseInt(args[1]);
        int m = 4;
        int n = 4;

        // closure
        IShuffle shuffle = new IShuffle()
        {
            public void shuffle(int[] a)
            {
                StdRandom.shuffle(a);//这里产生随机数，ShuffleTest
            }
        };
        
        ShuffleTest(shuffle, m, n);
    }
}
