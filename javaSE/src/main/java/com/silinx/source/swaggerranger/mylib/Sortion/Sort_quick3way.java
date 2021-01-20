package com.silinx.source.swaggerranger.mylib.Sortion;


import com.silinx.source.swaggerranger.mylib.FileStdIn;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

/**********************************************************************
 *
 * 排序算法--快速排序--三向快速排序
 *传入数组，使用数组来实现排序
 *在快速排序的基础上做了改进以解决很多相等元素时的效率改进
 *思想：用两个指针lt,gt将元素分成3个部分和一个遍历指针i，v = a[i]:lo-lt<v,lt-i = v,i-gt未比较，gt-hi >v;
 *NlogN
 *
* *********************************************************************/
public class Sort_quick3way {

    //静态类，不能初始化对象
    private Sort_quick3way(){}

    /**********************************************************************
     * 以下是通用工具方法实现对元素的比较和交换,以及检查排序是否完成
    * *********************************************************************/
    private static boolean less( Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
    private static boolean less( Comparator comparator, Object a, Object b){
        return comparator.compare(a,b) < 0;
    }

    private static void exch( Object[] o, int i, int j){
        Object tmp = o[i];
        o[i] = o[j];
        o[j] = tmp;
    }

    private static boolean isSorted( Comparable[] comparators){return isSorted(comparators,0,comparators.length);}
    private static boolean isSorted( Comparable[] comparators, int lo, int hi){
        for(int i = lo;i < hi-1;i++)
            if(less(comparators[i+1],comparators[i])) return false;
        return true;
    }
    private static boolean isSorted( Object[] o, Comparator comparator){
        return isSorted(o,comparator,0,o.length);
    }
    private static boolean isSorted( Object[] o, Comparator comparator, int lo, int hi){
        for(int i = lo;i < hi-1;i++)
            if(less(comparator,o[i+1],o[i])) return false;
        return true;
    }

    private static void show( Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    /**********************************************************************
     * 以上是通用工具方法实现对元素的比较和交换,以及检查排序是否完成
     * *********************************************************************/

    //排序方法


    public static void sort( Comparable[] a ){
        sort(a,0,a.length - 1);
    }

    private static void sort( Comparable[] a, int lo, int hi){
        if (hi < lo) return;
        int lt =lo, i = lo+1; int gt = hi;
        Comparable v = a[lo];
        while( i <= gt){
            int cmp = a[i].compareTo(v);
            if      (cmp < 0 ) exch(a,lt++,i++);
            else if (cmp > 0 ) exch(a,i,gt--);  //这里i不是i++,i不需要后移还需要下次与前面的数进行比较
            else               i++;
        }

        sort(a,lo,lt-1);
        sort(a,lt+1,hi);

    }


    public static void sort( Object[] a , Comparator comparator){

    }


    public static void main( String[] args) throws FileNotFoundException {
        String str ="C:\\Swagger-Ranger\\algs4_github_fork\\AlgorithmsSedgewick\\2-Sorting\\2-1-ElementarySorts\\tiny" +
                ".txt";
        FileStdIn.setScanner(str);
        String[] a = FileStdIn.readAllStrings();

        System.out.println(Arrays.toString(a));
        Sort_quick3way.sort(a);
        System.out.println(isSorted(a));
        show(a);

    }
}
