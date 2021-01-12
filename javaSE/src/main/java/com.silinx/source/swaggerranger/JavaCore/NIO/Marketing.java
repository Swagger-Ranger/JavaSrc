package com.silinx.source.swaggerranger.JavaCore.NIO;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2020,github:Swagger-Ranger </p>
 * <p>@FileName:    Marketing </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2020/1/28 15:06 </p>
 * <p>@Description: Scatter/Gather 一个使用通道的NIO读写实例类</p>
 * <p>@Aha-eureka:  scatter:用于读read,channel将通道另一头中的数据分散到buffer[]中
 *                  gather:用于write,channel将buffer[]中的数据汇总写到管道的另一头中,比如这里的文件流
 * </p>
 ******************************************************************************/

public class Marketing {
    private static final String DEMOGRAPHIC = "blahblah.txt";

    // "Leverage frictionless methodologies"
    public static void main( String[] argv ) throws Exception {
        //给定默认的缓冲区大小,如果执行Java文件时有参数传入则使用参数大小
        int reps = 10;
        if (argv.length > 0) {
            reps = Integer.parseInt(argv[0]);
        }

        FileOutputStream fos = new FileOutputStream(DEMOGRAPHIC);
        GatheringByteChannel gatherChannel = fos.getChannel();

        // Generate some brilliant marcom, er, repurposed content
        ByteBuffer[] bs = utterBS(reps);
        // Deliver the message to the waiting market
        while (gatherChannel.write(bs) > 0) {
            // Empty body
            // Loop until write( ) returns zero
        }
        System.out.println("Mindshare paradigms synergized to "
                + DEMOGRAPHIC);
        fos.close();
    }

    // ------------------------------------------------
    // These are just representative; add your own
    private static String[] col1 = {
            "Aggregate", "Enable", "Leverage",
            "Facilitate", "Synergize", "Repurpose",
            "Strategize", "Reinvent", "Harness"
    };
    private static String[] col2 = {
            "cross-platform", "best-of-breed", "frictionless",
            "ubiquitous", "extensible", "compelling",
            "mission-critical", "collaborative", "integrated"
    };
    private static String[] col3 = {
            "methodologies", "infomediaries", "platforms",
            "schemas", "mindshare", "paradigms",
            "functionalities", "web services", "infrastructures"
    };
    private static String newline = System.getProperty("line.separator");

    // The Marcom-atic 9000
    private static ByteBuffer[] utterBS( int howMany )
            throws Exception {
        List list = new LinkedList();
        for (int i = 0; i < howMany; i++) {
            list.add(pickRandom(col1, " "));
            list.add(pickRandom(col2, " "));
            list.add(pickRandom(col3, newline));
        }
        ByteBuffer[] bufs = new ByteBuffer[list.size()];
        list.toArray(bufs);
        return (bufs);
    }

    // The communications director
    private static Random rand = new Random();

    // Pick one, make a buffer to hold it and the suffix, load it with
    // the byte equivalent of the strings (will not work properly for
    // non-Latin characters), then flip the loaded buffer so it's ready
    // to be drained
    private static ByteBuffer pickRandom( String[] strings, String suffix )
            throws Exception {
        String string = strings[rand.nextInt(strings.length)];
        int total = string.length() + suffix.length();
        ByteBuffer buf = ByteBuffer.allocate(total);
        buf.put(string.getBytes("US-ASCII"));
        buf.put(suffix.getBytes("US-ASCII"));
        buf.flip();
        return (buf);
    }
}
