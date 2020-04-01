package com.silinx.source.algs4.Chapter5.chapter5_1;

import com.silinx.source.algs4.algs4_lib.StdOut;

/***********************************************************************************
 *  Compilation: javac MSD_false.java
 *  Execution:   java MSD_false < input.txt
 *
 *  Reads extended ASCII string from standard input and MSD_false radix sorts them.
 *
 *  % java MSD_false < shells.txt
 *  are
 *  by
 *  sea
 *  seashells
 *  seashells
 *  sells
 *  sells
 *  she
 *  she
 *  shells
 *  shore
 *  surely
 *  the
 *  the
 *
 *  这个类是由问题的，不完整，同时测试的用例不会运行到索引排序的代码片段
 *  高位优先字符串排序---LSD：Max-Significant-Digit First
 *  相对于LSD，MSD不需要将字符全部排序就能得到前n个排序的结果
 *  相比LSD只能排序等长的字符串，MSD则可以排序不等长的字符串，但需要注意是否到了字符串的末尾
 ***********************************************************************************/

public class MSD_false {
    private static final int R      = 256;   // extended ASCII alphabet size--键的基数
    private static final int CUTOFF =  15;   // cutoff to insertion sort--小数组切分的阈值（临界值）

    // sort array of strings
    public static void sort( String[] a) {
        int N = a.length;
        String[] aux = new String[N];
        sort(a, 0, N-1, 0, aux);
    }

    // return dth character of s, -1 if d = length of string
    private static int charAt( String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        return s.charAt(d);
    }

    // sort from a[lo] to a[hi], starting at the dth character--以第d个字符为键将字符数组从a[lo]到a[hi]排序
    private static void sort( String[] a, int lo, int hi, int d, String[] aux) {

        // cutoff to insertion sort for small subarrays，按cutoff为大小将数组切分为小数组再排序
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
//            Insertion.sort(a, lo, hi, d);
            return;             //这里的return会直接退出函数，不执行下面的索引计数排序程序块,即小数组不执行
        }

        // compute frequency counts
        int[] count = new int[R+2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c+2]++;
        }

        // transform counts to indicies
        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];

        // distribute
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c+1]++] = a[i];
        }

        // copy back
        for (int i = lo; i <= hi; i++) 
            a[i] = aux[i - lo];


        System.out.println("123456788");
        // recursively sort for each character--以每个字符作为键进行递归排序
        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
    }


    // return dth character of s, -1 if d = length of string--这里就是在做冒泡排序
    private static void insertion( String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)   //for循环的条件判断为假则直接退出，所以这里的循环只执行一次在后面的数小于前面的情况下
                exch(a, j, j-1);
    }

    // exchange a[i] and a[j]
    private static void exch( String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // is v less than w, starting at character d
    private static boolean less( String v, String w, int d) {
        assert v.substring(0, d).equals(w.substring(0, d));
        return v.substring(d).compareTo(w.substring(d)) < 0; 
    }


    public static void main( String[] args) {
//        String[] a = StdIn.readStrings();
        String input = "she sells seashells by the sea shore " +
                "the shells she sells are surely seashells";
        String[] a= input.split(" ");
        int N = a.length;
        sort(a);
        for (int i = 0; i < N; i++)
            StdOut.println(a[i]);
    }
}
