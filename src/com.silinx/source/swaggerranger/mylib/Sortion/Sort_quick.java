package com.silinx.source.swaggerranger.mylib.Sortion;

import com.silinx.source.swaggerranger.mylib.FileStdIn;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

/**********************************************************************
 * 排序算法--快速排序
 *传入数组，使用数组来实现排序
 *应用最广泛的排序方法，在时间和空间上都比较优；思想：找到某个切分位置，左边的元素都小于切分元素，右边的都大于切分元素，关键就是实现位置切分
 *NlogN
 *
* *********************************************************************/
public class Sort_quick {

    //静态类，不能初始化对象
    private Sort_quick(){}

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

    //partition切分方法
    private static int partition( Comparable[] a, int lo, int hi){
        int i =lo, j = hi +1;
        Comparable v = a[lo];
        while (true){
            while (less(a[++i],v)) if( i == hi) break;   //将左边的数进行比较，直到遇到大于切分位置元素V时或者到最右边时推出
            while (less(v,a[--j])) if( j == lo) break;   //将右边的数进行比较，直到遇到小于切分位置元素V时或者到最左边时推出
            if(i >= j)             break;                //因为之前进行了比较所以当前的i，j不相遇的话就交换，相遇就推出
            exch(a,i,j);
        }
        exch(a,lo,j);                                    //将切分元素放到切分位置：因为原来的切分元素保存的是v = a[i=lo],而交换后的切分位置是j；
        return j;
    }

    public static void sort( Comparable[] a ){
        sort(a,0,a.length - 1);
    }

    private static void sort( Comparable[] a, int lo, int hi){
        if(lo >= hi) return;   //退出条件
        int j = partition(a,lo,hi);     //找到切分位置
        sort(a,lo,j-1);                   //从切分位置继续递归
        sort(a,j+1,hi);

    }


    public static void sort( Object[] a , Comparator comparator){

    }


    public static void main( String[] args) throws FileNotFoundException {
        String str ="C:\\Swagger-Ranger\\algs4_github_fork\\AlgorithmsSedgewick\\2-Sorting\\2-1-ElementarySorts\\tiny" +
                ".txt";
        FileStdIn.setScanner(str);
        String[] a = FileStdIn.readAllStrings();

        System.out.println(Arrays.toString(a));
        Sort_quick.sort(a);
        System.out.println(isSorted(a));
        show(a);

    }
}
