package com.silinx.source.swaggerranger.JavaCore.NIO;

import java.nio.CharBuffer;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2020,github:Swagger-Ranger </p>
 * <p>@FileName:    BufferFillDrain </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2020/1/26 17:32 </p>
 * <p>@Description: buffer缓冲区的填充与释放 </p>
 * <p>@Aha-eureka: </p>
 ******************************************************************************/

public class BufferFillDrain {

    public static void main( String[] argv ) {
        CharBuffer buffer = CharBuffer.allocate(100);
        /**
         * 这里只使用了一个charBuffer来写入和读出即填充与释放
         * 读取一个字符串数组,每次只读取数组中的一个元素填充缓冲区,
         * 然后翻转缓冲区,
         * 读出缓冲区,
         * 并清空缓冲区,其实clear只是重置缓冲区里的position和limit并没有实际的删除其中的数据
         */
        while (fillBuffer(buffer)) {
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }
    }

    private static void drainBuffer( CharBuffer buffer ) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println("");
    }

    private static boolean fillBuffer( CharBuffer buffer ) {
        if (index >= strings.length) {
            return (false);
        }
        String string = strings[index++];
        for (int i = 0; i < string.length(); i++) {
            buffer.put(string.charAt(i));
        }
        return (true);
    }

    private static int index = 0;
    private static String[] strings = {
            "A random string value",
            "The product of an infinite number of monkeys",
            "Hey hey we're the Monkees",
            "Opening act for the Monkees: Jimi Hendrix",
            "'Scuse me while I kiss this fly", // Sorry Jimi ;-)
            "Help Me! Help Me!",
    };
}
