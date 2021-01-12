package com.silinx.source.swaggerranger.mylib.Sortion;


import com.silinx.source.swaggerranger.mylib.FileStdIn;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

/**********************************************************************
*
* 排序算法--插入排序的改进型，哨兵去掉比较的内循环
*传入数组，使用数组来实现排序
*先找到所有元素中最小的，放到最左边，这样可以去掉内循环的判断条件j >0，并且可以先判断是否已经排好序和减少交换的次数,实际上内部就是一个插入排序
 *
 *N^2的复杂度
 *
* *********************************************************************/
public class Sort_sentinel {

    //静态类，不能初始化对象
    private Sort_sentinel(){}

    //以下是通用工具方法实现对元素的比较和交换,以及检查排序是否完成
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


    //排序方法
    public static void sort( Comparable[]a ){
        sort(a,0,a.length);
    }

    public static void sort( Comparable[] a , int lo , int hi){

        int n = hi - lo;
        assert (n < 0):"ERROR:high < low ！";

        //一个循环，一步一步的从右往左将最小的数找到并放到最左边保证最左边的数是最小的
        int exchanges = 0;
        for (int i = n-1; i > 0; i--) {
            if (less(a[lo + i], a[lo + i-1])) {
                exch(a, lo + i, lo + i-1);
                exchanges++;
            }
        }
        if (exchanges == 0) return; //如果没有经过交换则证明已经排好序，直接退出


        // insertion sort with half-exchanges 不作交换，而是将类似于选择排序的从右边逐步的插入左边
        for (int i = 2; i < n; i++) {
            Comparable v = a[lo + i];
            int j = lo + i;
            while (less(v, a[lo + j-1])) {
                a[lo + j] = a[lo + j-1];  //遇到更小的则将之前的数往后移一位（最后一个数保存在v里面，这样实际上就是只做一次交换避免每次都交换）
                j--;
            }
            a[lo + j] = v;
        }
        assert isSorted(a,lo,hi) :"sort failed!";
    }

    public static void sort( Object[] a , Comparator comparator){
        sort(a,0,a.length,comparator);
    }

    public static void sort( Object[] a, int lo, int hi, Comparator comparator){
        System.out.println("still not completed!");
        assert isSorted(a,comparator,lo,hi) :"sort failed!";
    }

    public static void main( String[] args) {
        String str ="C:\\Swagger-Ranger\\algs4_github_fork\\AlgorithmsSedgewick\\2-Sorting\\2-1-ElementarySorts\\tiny" +
                ".txt";
        try {
            FileStdIn.setScanner(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] a = FileStdIn.readAllStrings();
        System.out.println(Arrays.toString(a));
        Sort_sentinel.sort(a);
        System.out.println(isSorted(a));
        show(a);

    }
}
