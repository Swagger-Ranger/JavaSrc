package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.FrameworkAndTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: SimpleDBConnectionPool
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/11 14:48
 * @Description: 简易的数据库连接池
 * @Aha-eureka:
 *******************************************************************************/

public class SimpleDBConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    //数据库连接池的配置i
    private static final int INIT_COUNT = 10;
    private static final String DRIVER_CLASS = "";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static final String URL = "";

    //线程同步
    private Lock lock = new ReentrantLock();
    private Condition c = lock.newCondition();

    //加载驱动类
    static {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public SimpleDBConnectionPool() {

        //循环获取指定容量的链接
        for (int i = 0; i <INIT_COUNT ; i++) {
            try {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                pool.add(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取链接
     * @return
     */
    public Connection getConnect() {
        Connection con = null;
        lock.lock();

        try {
            while (pool.size() <= 0) {

                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!pool.isEmpty()) {
                con = pool.removeFirst();
            }
        }finally {
            lock.unlock();
        }

        return con;
    }

    public void releaseConnect( Connection connection) {
        lock.lock();

        try {
            if (connection != null) {
                pool.addLast(connection);
                c.signal();
            }
        }finally {
            lock.unlock();
        }
    }


}
