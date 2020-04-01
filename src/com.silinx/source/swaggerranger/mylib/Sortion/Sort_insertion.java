package com.silinx.source.swaggerranger.mylib.Sortion;

import com.silinx.source.swaggerranger.mylib.FileStdIn;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

/**********************************************************************
*
* 排序算法--插入排序（冒泡排序）
 *
*传入数组，使用数组来实现排序
*思想如同打牌时将手中的牌整理排序，将后面的无序的牌依次插入到前面已经有序的牌中
 * N^2
* *********************************************************************/
public class Sort_insertion {

    //静态类，不能初始化对象
    private Sort_insertion(){}

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
        for(int i =lo; i<hi ; i++){
            for(int j =i; j>lo && less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
        assert isSorted(a,lo,hi);
    }

    public static void sort( Object[] a , Comparator comparator){
        sort(a,0,a.length,comparator);
    }

    public static void sort( Object[] a, int lo, int hi, Comparator comparator){
        for(int i =lo;i<hi;i++){
            for (int j =i;j>lo && less(comparator,j,j-1);j--){
                exch(a,j,j--);
            }
        }
        assert isSorted(a,comparator,lo,hi) :"sort failed!";
    }

    public static void main( String[] args) {
        String str ="C:\\Swagger-Ranger\\algs4_github_fork\\AlgorithmsSedgewick\\2-Sorting\\2-1-ElementarySorts" +
                "\\words3" +
                ".txt";
        try {
            FileStdIn.setScanner(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] a = FileStdIn.readAllStrings();
        System.out.println(Arrays.toString(a));
        System.out.println(less("s","z"));
        Sort_insertion.sort(a);
        show(a);
    }
}
