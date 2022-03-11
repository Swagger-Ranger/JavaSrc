package com.silinx.source.concurrent.chapter25;

@FunctionalInterface
public interface CacheLoader<K, V>
{
    V load(K k);
}
