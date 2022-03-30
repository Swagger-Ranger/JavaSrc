package com.silinx.source.concurrent.chapter25;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LRUCache<K, V>
{
    private final LinkedList<K> keyList = new LinkedList<>();

    private final Map<K, V> cache = new HashMap<>();

    private final int capacity;

    private final CacheLoader<K, V> cacheLoader;

    public LRUCache(int capacity, CacheLoader<K, V> cacheLoader)
    {
        this.capacity = capacity;
        this.cacheLoader = cacheLoader;
    }

    public void put(K key, V value)
    {
        if (keyList.size() >= capacity)
        {
            K eldestKey = keyList.removeFirst();//eldest data
            cache.remove(eldestKey);
        }
        if (keyList.contains(key))
            keyList.remove(key);

        keyList.addLast(key);
        cache.put(key, value);
    }

    public V get(K key)
    {
        V value;
        boolean success = keyList.remove(key);
        if (!success)
        {
            value = cacheLoader.load(key);
            this.put(key, value);
        } else
        {
            value = cache.get(key);
            keyList.addLast(key);
        }
        return value;
    }

    public static void main(String[] args) throws InterruptedException {
        LRUCache<Integer, Reference> cache = new LRUCache<>(200, k -> new Reference());
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            cache.get(i);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("The " + i + " reference is cached");

        }
    }

    @Override
    public String toString()
    {
        return this.keyList.toString();
    }
}