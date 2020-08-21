package com.silinx.source.swaggerranger.JavaCore.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * 监听类
 * 继承Thread来使用一个单独的线程来实现了类似线程池的框架，实现了对线程的简单管理，
 * 每次有连接进来都新建一个线程去处理，并在accept时将在运行的线程和未运行线程做清理
 */
class ListeningThread extends Thread {
    private SocketServer socketServer;
    private ServerSocket serverSocket;
    private Vector<ConnectionThread> connectionThreads;
    private Vector<ConnectionThread> notRunningConnectionThreads;
    private boolean isRunning;

    public ListeningThread(SocketServer socketServer, ServerSocket serverSocket) {
        this.socketServer = socketServer;
        this.serverSocket = serverSocket;
        this.connectionThreads = new Vector<ConnectionThread>();
        this.notRunningConnectionThreads = new Vector<ConnectionThread>();
        isRunning = true;
    }

    @Override
    public void run() {
        while(isRunning) {
            if (serverSocket.isClosed()) {
                isRunning = false;
                break;
            }

            // Remove not running connection threads.
            for (ConnectionThread connectionThread : connectionThreads) {
                if (!connectionThread.isRunning()) {
                    notRunningConnectionThreads.addElement(connectionThread);
                }
            }
            for (ConnectionThread connectionThread : notRunningConnectionThreads) {
                connectionThreads.remove(connectionThread);
            }
            notRunningConnectionThreads.clear();
            
            try {
                Socket socket;
                // Socket accept方法将阻塞，则到建立连接
                socket = serverSocket.accept();
                ConnectionThread connectionThread = new ConnectionThread(socket, socketServer);
                connectionThreads.addElement(connectionThread);
                connectionThread.start();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public void stopRunning() {
        for (int i = 0; i < connectionThreads.size(); i++)
            connectionThreads.elementAt(i).stopRunning();
        isRunning = false;
    }
} 