package com.silinx.source.algs4.Chapter2.chapter2_1;

/******************************************************************************
 *  Compilation:  javac Selection.java
 *  Execution:    java  Selection < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/21elementary/tiny.txt
 *                https://algs4.cs.princeton.edu/21elementary/words3.txt
 *
 *  Sorts a sequence of strings from standard input using selection sort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Selection < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Selection < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 ******************************************************************************/

import com.silinx.source.algs4.algs4_lib.StdIn;
import com.silinx.source.algs4.algs4_lib.StdOut;

import java.util.Comparator;

public class Selection {

    // This class should not be instantiated.
    private Selection() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort( Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * @param a the array
     * @param comparator the comparator specifying the order
     */
    public static void sort( Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(comparator, a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, comparator, 0, i);
        }
        assert isSorted(a, comparator);
    }


    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less( Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private static boolean less( Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }


    // exchange a[i] and a[j]
    private static void exch( Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    // is the array a[] sorted?
    private static boolean isSorted( Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted( Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array a[] sorted?
    private static boolean isSorted( Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted( Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static void show( Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; selection sorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main( String[] args) {
        String[] a = StdIn.readAllStrings();
        Selection.sort(a);
        show(a);
    }
}
