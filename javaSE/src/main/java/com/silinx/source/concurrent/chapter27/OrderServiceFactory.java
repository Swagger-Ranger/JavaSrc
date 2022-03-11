//package com.silinx.source.concurrent.chapter27;
//
//public final class OrderServiceFactory
//{
//    private final static ActiveMessageQueue activeMessageQueue = new ActiveMessageQueue();
//
//    private OrderServiceFactory()
//    {
//    }
//
//    public static OrderService toActiveObject(OrderService orderService)
//    {
//        return new OrderServiceProxy(orderService, activeMessageQueue);
//    }
//}
