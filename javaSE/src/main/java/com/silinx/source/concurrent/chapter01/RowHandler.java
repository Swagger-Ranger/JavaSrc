package com.silinx.source.concurrent.chapter01;

import java.sql.ResultSet;

public interface RowHandler<T>
{

    T handle(ResultSet rs);
}
