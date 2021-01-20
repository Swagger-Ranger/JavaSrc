package com.silinx.source.algs4.Chapter3.chapter3_5; /*************************************************************************
 *  Compilation:  javac ST.java
 *  Execution:    java ST
 *  
 *  Sorted symbol table implementation using a java.util.TreeMap.
 *  Does not allow duplicates.
 *
 *  % java ST
 *  使用treemap为底层实现的有序符号表
 *************************************************************************/

import com.silinx.source.algs4.algs4_lib.StdOut;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    private TreeMap<Key, Value> st;

    /**
     * Create an empty symbol table.
     */
    public ST() {
        st = new TreeMap<Key, Value>();
    }

    /**
     * Put key-value pair into the symbol table. Remove key from table if
     * value is null.
     */
    public void put(Key key, Value val) {
        if (val == null) st.remove(key);
        else             st.put(key, val);
    }

    /**
     * Return the value paired with given key; null if key is not in table.
     */
    public Value get(Key key) {
        return st.get(key);
    }

    /**
     * Delete the key (and paired value) from table.
     * Return the value paired with given key; null if key is not in table.
     */
    public Value delete(Key key) {
        return st.remove(key);
    }

    /**
     * Is the key in the table?
     */
    public boolean contains(Key key) {
        return st.containsKey(key);
    }

    /**
     * How many keys are in the table?
     */
    public int size() {
        return st.size();
    }

    /**
     * Return an <tt>Iterable</tt> for the keys in the table.
     * To iterate over all of the keys in the symbol table <tt>st</tt>, use the
     * foreach notation: <tt>for (Key key : st.keys())</tt>.
     */ 
    public Iterable<Key> keys() {
        return st.keySet();
    }

   /**
     * Return an <tt>Iterator</tt> for the keys in the table.
     * To iterate over all of the keys in the symbol table <tt>st</tt>, use the
     * foreach notation: <tt>for (Key key : st)</tt>.
     * This method is for backward compatibility with the version from <em>Introduction
     * to Programming in Java: An Interdisciplinary Approach.</em>
     */
    public Iterator<Key> iterator() {
        return st.keySet().iterator();
    }

    /**
     * Return the smallest key in the table.
     */ 
    public Key min() {
        return st.firstKey();
    }

    /**
     * Return the largest key in the table.
     */ 
    public Key max() {
        return st.lastKey();
    }


    /**
     * Return the smallest key in the table >= k.
     */ 
    public Key ceil(Key k) {
        SortedMap<Key, Value> tail = st.tailMap(k);
        if (tail.isEmpty()) return null;
        else return tail.firstKey();
    }

    /**
     * Return the largest key in the table <= k.
     */ 
    public Key floor(Key k) {
        if (st.containsKey(k)) return k;

        // does not include key if present (!)
        SortedMap<Key, Value> head = st.headMap(k);
        if (head.isEmpty()) return null;
        else return head.lastKey();
    }

   /***********************************************************************
    * Test routine.
    **********************************************************************/
    public static void main( String[] args) {
        ST<String, String> st = new ST<String, String>();

       // insert some key-value pairs
        st.put("www.cs.princeton.edu",   "128.112.136.11");
        st.put("www.cs.princeton.edu",   "128.112.136.35");    // overwrite old value
        st.put("www.princeton.edu",      "128.112.130.211");
        st.put("www.math.princeton.edu", "128.112.18.11");
        st.put("www.yale.edu",           "130.132.51.8");
        st.put("www.amazon.com",         "207.171.163.90");
        st.put("www.simpsons.com",       "209.123.16.34");
        st.put("www.stanford.edu",       "171.67.16.120");
        st.put("www.google.com",         "64.233.161.99");
        st.put("www.ibm.com",            "129.42.16.99");
        st.put("www.apple.com",          "17.254.0.91");
        st.put("www.slashdot.com",       "66.35.250.150");
        st.put("www.whitehouse.gov",     "204.153.49.136");
        st.put("www.espn.com",           "199.181.132.250");
        st.put("www.snopes.com",         "66.165.133.65");
        st.put("www.movies.com",         "199.181.132.250");
        st.put("www.cnn.com",            "64.236.16.20");
        st.put("www.iitb.ac.in",         "202.68.145.210");


        StdOut.println(st.get("www.cs.princeton.edu"));
        StdOut.println(st.get("www.harvardsucks.com"));
        StdOut.println(st.get("www.simpsons.com"));
        StdOut.println();

        StdOut.println("ceil(www.simpsonr.com) = " + st.ceil("www.simpsonr.com"));
        StdOut.println("ceil(www.simpsons.com) = " + st.ceil("www.simpsons.com"));
        StdOut.println("ceil(www.simpsont.com) = " + st.ceil("www.simpsont.com"));
        StdOut.println("floor(www.simpsonr.com) = " + st.floor("www.simpsonr.com"));
        StdOut.println("floor(www.simpsons.com) = " + st.floor("www.simpsons.com"));
        StdOut.println("floor(www.simpsont.com) = " + st.floor("www.simpsont.com"));

        StdOut.println();

        StdOut.println("min key: " + st.min());
        StdOut.println("max key: " + st.max());
        StdOut.println("size:    " + st.size());
        StdOut.println();

        // print out all key-value pairs in lexicographic order
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

}
