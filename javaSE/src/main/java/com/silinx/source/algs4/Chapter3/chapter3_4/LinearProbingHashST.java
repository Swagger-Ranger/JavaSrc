package com.silinx.source.algs4.Chapter3.chapter3_4;

import com.silinx.source.algs4.algs4_lib.Queue;
import com.silinx.source.algs4.algs4_lib.StdIn;
import com.silinx.source.algs4.algs4_lib.StdOut;

/*************************************************************************
 *  Compilation:  javac LinearProbingHashST.java
 *  Execution:    java LinearProbingHashST
 *  
 *  Symbol table implementation with linear probing hash table.
 *
 *  % java LinearProbingHashST
 *  128.112.136.11
 *  208.216.181.15
 *  null
 *
 * 指针散列表
 * 直接使用一对数组来存放键值对，遇到hash冲突就往后移一位，使得每个键都被平铺在一张表上，使得查找速度提升
 * 插入和删除是个难点：
 * 插入，需要去检查是否被占用，然后不断往后移
 * 删除，需要向插入一样不断去求hash值来查找到对应的值，然后还要将这个值后面因为这个值占用的哈希值的键往前挪，不然就会导致后面的值无法被查找
 * 同时插入和删除还需要去检查N的大小来维持一个良好的比例：
 *      插入后检查来保证键簇（就是连续的键的集合）不至于太长导致效率降低，和删除后检查使比例不至于太小（空白键太多以至于浪费空间）
 *
 *************************************************************************/


public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int N;           // number of key-value pairs in the symbol table
    private int M;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values


    // create an empty hash table - use 16 as default size
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    // create linear proving hash table of given capacity
    public LinearProbingHashST(int capacity) {
        M = capacity;
        keys = (Key[])   new Object[M];
        vals = (Value[]) new Object[M];
    }

    // return the number of key-value pairs in the symbol table
    public int size() {
        return N;
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // does a key-value pair with the given key exist in the symbol table?
    public boolean    contains(Key key) {
        return get(key) != null;
    }

    // hash function for keys - returns value between 0 and M-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    // resize the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        M    = temp.M;
    }

    // insert the key-value pair into the symbol table
    public void put(Key key, Value val) {
        if (val == null) delete(key);

        // double table size if 50% full
        if (N >= M/2) resize(2*M);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {     //这里非常巧妙，对for循环要有本质的理解
            if (keys[i].equals(key)) { vals[i] = val; return; }     //如果已经存在就直接退出
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    // return the value associated with the given key, null if no such value
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) 
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    // delete the key (and associated value) from the symbol table
    public void delete(Key key) {
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % M;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;  
            put(keyToRehash, valToRehash);
            i = (i + 1) % M;
        }

        N--;        

        // halves size of array if it's 12.5% full or less
        if (N > 0 && N <= M/8) resize(M/2);

        assert check();
    }

    // return all of the keys as in Iterable
    public Iterable<Key> keys() {   //直接返回一个接口的实现类
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }

    // integrity check - don't check after each put() because
    // integrity not maintained during a delete()
    private boolean check() {   //检查M/N的比例和键值对是否对应

        // check that hash table is at most 50% full
        if (M < 2*N) {
            System.err.println("Hash table size M = " + M + "; array size N = " + N);
            return false;
        }

        // check that each key in table can be found by get()
        for (int i = 0; i < M; i++) {
            if (keys[i] == null) continue;
            else if (get(keys[i]) != vals[i]) {
                System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + vals[i]);
                return false;
            }
        }
        return true;
    }


/***********************************************************************
    *  Unit test client.
    ***********************************************************************/
    public static void main( String[] args) {
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        // print keys
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
