package com.silinx.source.swaggerranger.mylib.Sortion;

import com.silinx.source.swaggerranger.mylib.FileStdIn;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

/**********************************************************************
*
* 排序算法--选择排序
 *
*传入数组，使用数组来实现排序
*依次在所剩的数组元素中寻找最小的，放到最左边
 * N^2
* *********************************************************************/
public class Sort_selection {

    //静态类，不能初始化对象
    private Sort_selection(){}

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
        for(int i = lo;i < hi;i++){
            int min =i;
            for(int j = i;j<hi;j++){
                if(less(a[j],a[min])) min =j;
            }
            exch(a,i,min);
        }
        assert isSorted(a,lo,hi) :"sort failed!";
    }

    public static void sort( Object[] a , Comparator comparator){
        sort(a,0,a.length,comparator);
    }

    public static void sort( Object[] a, int lo, int hi, Comparator comparator){
        for(int i = lo;i < hi;i++){
            int min =i;
            for(int j = i;j<hi;j++){
                if(less(comparator,a[j],a[min])) min =j;
            }
            exch(a,i,min);
        }
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
        Sort_selection.sort(a);
        System.out.println(isSorted(a));
        show(a);
    }
}
