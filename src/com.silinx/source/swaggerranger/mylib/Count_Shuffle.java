package com.silinx.source.swaggerranger.mylib;


import com.silinx.source.algs4.algs4_lib.StdOut;
import com.silinx.source.algs4.algs4_lib.StdRandom;

//乱序检查：接受参数M,N，将大小为M的数组打乱N次，每次打乱前都将数组初始化为a[i] = i 。打印一个M*N的数组，对于所有的列J，行表示i打乱后落到j位置的次数
public class Count_Shuffle
{
    public interface IShuffle  //内部接口，将打乱的具体方式，也就是使用什么算法来打乱数组留给实现者
    {
        public void shuffle( int[] a );     //打乱的方法

    }
    // 大小为M，打乱次数为N
    public static void ShuffleTest(IShuffle shuffle, int m, int n)
    {
        int[][] s = new int[m][m];

        for (int k = 0; k < n; k++) //这个循环就是在得到一个打乱的分布二维数组,即s
        {
            int[] a = new int[m];
            for (int i = 0; i < m; i++) //执行重置操作
                a[i] = i;

            shuffle.shuffle(a);  //执行每次的打乱操作<---即就是要检验这个打乱shuffle的效果

            for (int i = 0; i < m; i++)
                s[i][a[i]]++;   //执行计数操作  数i被打乱后落在j列（即a[i]，注意这里的a已经被打乱了,那么a[i]就指向被打乱了的数组位置)的次数;会重复n次
        }

        for (int i = 0; i < m; i++)  //打印被打乱的二维数组s
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

