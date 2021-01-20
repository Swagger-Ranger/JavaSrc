package com.silinx.source.swaggerranger.mylib;

import com.silinx.source.algs4.algs4_lib.BinarySearch;
import com.silinx.source.algs4.algs4_lib.StdOut;
import com.silinx.source.algs4.algs4_lib.StdRandom;

import java.util.Arrays;


//随机匹配：接受参数整型T，并分别针对N=10^3,10^4,10^5,10^6将实验运行T遍：生成两个大小为
//N的随机6位正整数并查找出同时存在于两个数组中的整数数量。打印出表格，对于每个N，给出T次实验中该数量的平均值

public class Random_Match {
    public static int experiment(int n)
    {
        int[] a = new int[n],
                b = new int[n];

        for (int i = 0; i < n; i++)
        {
            a[i] = StdRandom.uniform(100000, 1000000);
            b[i] = StdRandom.uniform(100000, 1000000);
        }

        Arrays.sort(b);

        int count = 0;
        for (int i = 0; i < n; i++)
            if (BinarySearch.rank(a[i], b) >= 0)
                count++;

        return count;
    }

    public static void batch(int t, int n)
    {
        long count = 0;
        for (int i = 0; i < t; i++)
            count += experiment(n);

        double avg = 1.0 * count / t;

        StdOut.printf("%8d: %9.2f\n", n, avg);
    }

    public static void main( String[] args)
    {
//        int t = Integer.parseInt(args[0]);
        int t = 4;

        int[] ns = { 1000, 10000, 100000, 1000000 };

        for (int i = 0; i < ns.length; i++)
            batch(t, ns[i]);

        /*
                 1000:      0.96
                10000:    110.68
               100000:  10527.36
              1000000: 670822.20
         */
    }
}
