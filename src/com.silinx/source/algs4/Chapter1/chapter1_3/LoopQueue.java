package com.silinx.source.algs4.Chapter1.chapter1_3;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LoopQueue<Type> implements Iterable<Type> {

    private int N;
    private Node last;

    //the private inner node class;
    private class Node{
        private Type item;
        private Node next;
    }
    public LoopQueue(){
        last = null;
    }

    public boolean isEmpty(){ return last ==null; }

    public int size(){ return N; }

    public void enqueue(Type item){
        Node x = new Node();
        x.item = item;

        if(isEmpty()){
            x.next = x;
        }else {
            x.next = last.next;
            last.next = x;
        }
        last = x;
    }

    public Type dequeue(){
        if (isEmpty()) throw new NoSuchElementException("loopqueue underflow!");
        Type item = last.next.item;
        if(last.next ==last){
            last =null;
        }else {
            last.next = last.next.next;
        }
        return item;
    }
    public Type peek(){
        if(isEmpty())  throw new RuntimeException("LoopQueue underflow!");
        return last.next.item;
    }

    public String toString() {
        StringBuilder str =new StringBuilder("");
        for(Type item: this){
            str.append(item + "-->");
        };
        return str.toString();
    }

    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Type> {
        private int n = N;
        private Node current = last;

        public boolean hasNext()  { return n > 0; }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Type next() {
            if (!hasNext()) throw new NoSuchElementException();
            Type item = current.next.item;
            current = current.next;
            n--;
            return item;
        }
    }
}
