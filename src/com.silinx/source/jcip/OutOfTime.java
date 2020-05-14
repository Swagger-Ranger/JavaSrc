package com.silinx.source.jcip;

import java.util.*;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * OutOfTime
 * <p/>
 * Class illustrating confusing Timer behavior
 *
 * @author Brian Goetz and Tim Peierls
 */

public class OutOfTime {
    public static void main( String[] args) throws Exception {
        Timer timer = new Timer();


        try {

            System.out.println("000000000000000");
            timer.schedule(new ThrowTask(), 1);
        }finally {
            System.out.println("-------------");
            System.out.println(Thread.currentThread().getState());

        }


        SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 1);
        SECONDS.sleep(5);
    }

    static class ThrowTask extends TimerTask {
        public void run() {
            System.out.println("run-------");
            throw new RuntimeException();
        }
    }
}
