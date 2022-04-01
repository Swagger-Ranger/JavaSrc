package com.silinx.source.concurrent.chapter27.type2;

import com.silinx.source.concurrent.chapter19.Future;

/***************************************
 * @author:Alex Wang
 * @Date:2017/12/3
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public interface OrderService
{
    Future<String> findOrderDetails(long orderId);

    void order(String account, long orderId);
}
