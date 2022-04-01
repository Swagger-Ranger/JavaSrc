package com.silinx.source.concurrent.chapter27.type1;

import com.silinx.source.concurrent.chapter19.Future;

import java.util.Map;

public class FindOrderDetailsMessage extends MethodMessage
{
    public FindOrderDetailsMessage(Map<String, Object> params
            , OrderService orderService)
    {
        super(params, orderService);
    }

    @Override
    public void execute()
    {
        Future<String> realFuture = orderService.findOrderDetails((Long) params.get("orderId"));
        ActiveFuture<String> activeFuture = (ActiveFuture<String>) params.get("activeFuture");
        try
        {
            String result = realFuture.get();
            activeFuture.finish(result);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
            activeFuture.finish(null);
        }
    }
}