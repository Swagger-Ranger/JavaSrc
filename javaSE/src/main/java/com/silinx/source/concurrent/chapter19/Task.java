package com.silinx.source.concurrent.chapter19;
@FunctionalInterface
public interface Task<IN, OUT>
{
    OUT get(IN input);
}
