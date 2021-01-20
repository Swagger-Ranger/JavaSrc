package com.silinx.source.algs4.Chapter2;

import java.util.Comparator;

public class Sortions {

    //utility class all method is Static,can not be instance
    private Sortions(){}

    /**
     *工具方法
     *
     * */
    private static void exch( Object[] a, int i, int j){
        Object swap = a[i];
        a[i]        = a[j];
        a[j]        = swap;
    }

    private static boolean less( Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean less( Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    private static boolean isSorted( Comparable[] a) {
        return isSorted(a, 0, a.length);
    }

    // is the array a[lo..hi) sorted
    private static boolean isSorted( Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i < hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    /**
     *
     * 排序方法
     */
    public static void insertion( Comparable[] a){

    }

    public static void selection( Comparable[] a){

    }

    public static void shell( Comparable[] a){

    }

    public static void mergeUB( Comparable[] a){

    }

    public static void mergeBU( Comparable[] a){

    }

    public static void quick( Comparable[] a){

    }

    public static void quick3way( Comparable[] a){}

    public static void heap(){}


}
