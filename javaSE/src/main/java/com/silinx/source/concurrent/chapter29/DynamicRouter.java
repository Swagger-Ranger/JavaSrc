package com.silinx.source.concurrent.chapter29;

public interface DynamicRouter<E extends Message>
{
    void registerChannel(Class<? extends E> messageType,
                         Channel<? extends E> channel);

    void dispatch(E message);
}