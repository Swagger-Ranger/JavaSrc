package com.silinx.source.concurrent.chapter27;

import com.silinx.source.concurrent.chapter19.FutureTask;

/***************************************
 * @author:Alex Wang
 * @Date:2017/12/4
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class ActiveFuture<T> extends FutureTask<T>
{
    @Override
    public void finish(T result)
    {
        super.finish(result);
    }
}