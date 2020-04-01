package com.silinx.source.swaggerranger.JavaCore.NIO;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2020,github:Swagger-Ranger </p>
 * <p>@FileName:    BufferCharView </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2020/1/27 17:54 </p>
 * <p>@Description: 视图缓冲区:创建一个 ByteBuffer 的字符㿼图 </p>
 * <p>@Aha-eureka: </p>
 ******************************************************************************/

public class BufferCharView {
    public static void main( String[] argv ) {
        ByteBuffer byteBuffer =
                ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();//这里从字节缓冲区,转换成char缓冲视图时自动将2位转换成一个char,因为char是占2个字节
        // Load the ByteBuffer with some bytes
        byteBuffer.put(0, (byte) 0);
        byteBuffer.put(1, (byte) 'H');
        byteBuffer.put(2, (byte) 0);
        byteBuffer.put(3, (byte) 'i');
        byteBuffer.put(4, (byte) 0);
        byteBuffer.put(5, (byte) '!');
        byteBuffer.put(6, (byte) 0);
        println(byteBuffer);
        println(charBuffer);
    }

    // Print info about a buffer
    private static void println( Buffer buffer ) {
        System.out.println("pos=" + buffer.position()
                + ", limit=" + buffer.limit()
                + ", capacity=" + buffer.capacity()
                + ": '" + buffer.toString() + "'");
    }
}
