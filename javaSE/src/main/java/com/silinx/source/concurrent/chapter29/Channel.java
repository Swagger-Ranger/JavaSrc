package com.silinx.source.concurrent.chapter29;

public interface Channel<E extends Message>
{
    void dispatch(E message);
}
