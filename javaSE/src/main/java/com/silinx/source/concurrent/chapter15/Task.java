package com.silinx.source.concurrent.chapter15;

@FunctionalInterface
public interface Task<T>
{
    T call();
}
