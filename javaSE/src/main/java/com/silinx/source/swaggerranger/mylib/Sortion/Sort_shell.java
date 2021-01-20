package com.silinx.source.swaggerranger.mylib.Sortion;

import com.silinx.source.swaggerranger.mylib.FileStdIn;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

/**********************************************************************
*
* 排序算法--希尔排序
*传入数组，使用数组来实现排序
 *思想是h有序,任意间隔h都是有序地，当大规模排序时常常面对移动很慢的情况（因为都是一个一个地移动），而先将数组分成h份当数组是有序地时候每份都是有序时，
 * 在h很大时就可以实现将元素移动到很远地地方来避免位置较远时地过多比较和移动次数；然后缩小h到1就会实现整个数组地排序
 *N^(3/2)
 *
* *********************************************************************/
public class Sort_shell {

    //静态类，不能初始化对象
    private Sort_shell(){}

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
    public static void sort( Comparable[] a ){
        int h =1;
        if(h < a.length/3) h = 3*h +1;

        while (h >= 1){
            for( int i = h; i<a.length; i++){
                for(int j =i;j >= h && less(a[j],a[j-h]);j -=h){    //算法的关键，任意间隔h都有序，这里是将间隔h设置为3，h关系到算法的复杂度，这里还是个问题
                    exch(a,j,j-h);
                }
            }
            h = h/3;//缩小间隔
        }
    }



    public static void sort( Object[] a , Comparator comparator){

    }


    public static void main( String[] args) throws FileNotFoundException {
        String str ="C:\\Swagger-Ranger\\algs4_github_fork\\AlgorithmsSedgewick\\2-Sorting\\2-1-ElementarySorts\\tiny" +
                ".txt";
        FileStdIn.setScanner(str);

        String[] a = FileStdIn.readAllStrings();
        System.out.println(Arrays.toString(a));
        Sort_shell.sort(a);
        System.out.println(isSorted(a));
        show(a);

    }
}
