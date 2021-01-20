package com.silinx.source.swaggerranger.JavaCore.socket;

public interface MessageHandler {
    public void onReceive( Connection connection, String message );
}