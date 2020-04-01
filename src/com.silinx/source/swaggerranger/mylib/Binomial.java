/**   
 * Copyright © 2018 Swagger-Ranger All rights reserved.
 * 
 * @Package: mylib 
 * @author: Achin   
 * @date: 2018年5月27日 下午4:40:27 
 */
package com.silinx.source.swaggerranger.mylib;

import com.silinx.source.algs4.algs4_lib.Counter;
import com.silinx.source.algs4.algs4_lib.StdIn;
import com.silinx.source.algs4.algs4_lib.StdOut;

/**
 *TODO
 *Achin
 *2018年5月27日
 */
public class Binomial {
	public static double binomial(int n, int k, double p, Counter c)
    {
        double[][] v = new double[n+1][k+1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                v[i][j] = -1;
        
        return binomial(v, n, k, p, c);
    }
    
    public static double binomial(double[][] v, int n, int k, double p, Counter c)
    {
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;
        
        if (v[n][k] == -1)
        {
            c.increment();
            v[n][k] = (1.0 - p) * binomial(v, n-1, k, p, c) + p * binomial(v, n-1, k-1, p, c);
            //n次事件，发生k次=发生*(n-1次中不发生）+不发生*（n-1次中发生）
        }
        
        return v[n][k];
    }
    
    public static void main( String[] args)
    {
        int n = StdIn.readInt();
        int k = StdIn.readInt();
        double p = StdIn.readDouble();

//    	int n = Integer.parseInt(args[0]),
//                k = Integer.parseInt(args[1]);
//            double p = Double.parseDouble(args[2]);
    	
        Counter c = new Counter("calls");
        
        double b = binomial(n, k, p, c);
        
        StdOut.println(b);
        StdOut.println(c);
//         java Binomial   10    5 0.5:        50 calls
//         java Binomial   20   10 0.5:       175 calls
//         java Binomial   30   15 0.5:       375 calls
//         java Binomial  100   50 0.5:     3,875 calls
//         java Binomial 1000  500 0.5:   376,250 calls
//         java Binomial 4000 2000 0.5: 6,005,000 calls
    }

}
