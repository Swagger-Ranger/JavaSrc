package com.silinx.source.concurrent.chapter27.type1;

import java.util.Map;

public abstract class MethodMessage
{
    protected final Map<String, Object> params;

    protected final OrderService orderService;

    public MethodMessage(Map<String, Object> params, OrderService orderService)
    {
        this.params = params;
        this.orderService = orderService;
    }

    public abstract void execute();
}
