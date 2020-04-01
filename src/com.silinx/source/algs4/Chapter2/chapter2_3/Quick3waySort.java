package com.silinx.source.algs4.Chapter2.chapter2_3;

public class Quick3waySort {
    Quick3waySort(){};

    public static void sort( Comparable[] a){ sort(a ,0,a.length-1);}

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

    //exchange the elements
    private static void exch( Object[] a, int i, int j){

        Object o = a[j];
        a[j]     = a[i];
        a[i]     = o;
    }

    public static void show( Comparable[]a){
        for( int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }

    public static void main( String[] args) {
        Integer[] str = {1,2,3,4,5,6,4,4,3,2,1,6,7,8,9,7,8,7};

//        String[] str = StdIn.readAllStrings();
        sort(str);
        show(str);
    }


}
