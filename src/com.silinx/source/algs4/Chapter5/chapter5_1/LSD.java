package com.silinx.source.algs4.Chapter5.chapter5_1;

import com.silinx.source.algs4.algs4_lib.StdIn;
import com.silinx.source.algs4.algs4_lib.StdOut;

/***********************************************************************************
 *  Compilation: javac LSD.java
 *  Execution:   java LSD < input.txt
 *
 *  LSD radix sort an array of extended ASCII strings, each of length W.
 *
 *  % java LSD < words3.txt
 *  all
 *  bad
 *  bed
 *  bug
 *  dad
 *  ...
 *  yes
 *  yet
 *  zoo
 *
 *  低位优先字符串排序---LSD：Least-Significant-Digit First
 *  LSD的关键--在于索引计数排序法（下面的3步）
 *      索引计数法的前提在于：值本身已经是排号序，再根据键的值再次排序
 *      LSD从末尾依次使用索引计数排序法来从后往前排序，本质上就是索引计数排序的扩展，即将后面的已经索引计数排序的当成以排序的值，当前的字符当成键再次排序
 *      LSD要求字符串等长且需要将字符全部比较后才能排序
 *      见书P459
 *  线性复杂度：和N个元素，R个字母表个数，~O(N+R)
 ***********************************************************************************/

public class LSD {

    // LSD radix sort
    public static void sort( String[] a, int W) {
        int N = a.length;
        int R = 256;   // extend ASCII alphabet size
        String[] aux = new String[N];

        for (int d = W-1; d >= 0; d--) {
            // sort by key-indexed counting on dth character

            // compute frequency counts 1.计算出现频率
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;

            // compute cumulates 2.频率转换为索引
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // move data 3.移动到辅助数组
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            // copy back回写
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }


    public static void main( String[] args) {
        String[] a = StdIn.readStrings();
        int N = a.length;

        // check that strings have fixed length
        int W = a[0].length();
        for (int i = 0; i < N; i++)
            assert a[i].length() == W : "Strings must have fixed length";

        // sort the strings
        sort(a, W);

        // print results
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
    }
}
