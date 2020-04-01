package com.silinx.source.algs4.Chapter1.chapter1_5;

import com.silinx.source.algs4.algs4_lib.StdIn;
import com.silinx.source.algs4.algs4_lib.StdOut;

/****************************************************************************
 *  Compilation:  javac QuickUnionUF.java
 *  Execution:  java QuickUnionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Quick-union algorithm.
 *  背景参见 QuickFindUF:本方法和QuickFindUF基于相同的数据结构（以节点为索引的数组）来处理，但方法互补，一个find快，这个则union快
 *  方法：将数组的值表示为更复杂的结构，数组的值是与之相联通的节点的节点数组引用--其中理解find方法是关键
 *  优点：union是常数级别的
 *  缺点：如果出现小分量归并到大分量中时仍然会出现find的操作n^2的情况
 ****************************************************************************/

public class QuickUnionUF {
    private int[] id;    // id[i] = parent of i
    private int count;   // number of components

    // instantiate N isolated components 0 through N-1
    public QuickUnionUF(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // return number of connected components
    public int count() {
        return count;
    }

    // return root of component corresponding to element p
    public int find(int p) {    //这个是算法的关键实现--可以通过union的实现保证最后一定会返回到初始节点自身上也就是对应的分量
        while (p != id[p])
            p = id[p];      //最后的P一定是根节点的值也就是分量（数组的值），因为分量中的所有元素相连接，只有根节点的链接是指向自身的环
        return p;
    }

    // are elements p and q in the same component?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // merge components containing p and q
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        id[i] = j; 
        count--;
    }

    public static void main( String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);

        // read in a sequence of pairs of integers (each in the range 0 to N-1),
         // calling find() for each pair: If the members of the pair are not already
        // call union() and print the pair.
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println("# components: " + uf.count());
    }


}
