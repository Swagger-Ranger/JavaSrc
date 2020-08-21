package com.silinx.source.swaggerranger.JavaCore.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * socket客户端
 */
public class SocketClient {
    private Socket socket;

    public SocketClient(InetAddress ip, int port) {
        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 向socket中输入信息
     * @param message
     */
    public void println(String message) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(new OutputStreamWriter(
                                     socket.getOutputStream()), true);
            writer.println(MessageFlag.pureMessage + message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * This function blocks.
     * 读取socket流中的输入
    */
    public String readLine() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(
                                        socket.getInputStream()));
            return reader.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }
    
    /*
     * Ready for use.
     */
    public void close() {
        try {
            // Send a message to tell the server to close the connection.
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                socket.getOutputStream()), true);
            writer.println(MessageFlag.connectionClosed);

            if (socket != null && !socket.isClosed())
                socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}