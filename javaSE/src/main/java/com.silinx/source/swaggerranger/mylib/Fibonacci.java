package com.silinx.source.swaggerranger.mylib;


import com.silinx.source.algs4.algs4_lib.StdOut;


public class Fibonacci {
/*	private int N ;
	public Fibonacci(int n) {
		N=n;
	}*/
	
	public static long  Fib(int N) {
		long[] f =new long[N+1];
		return Fib(N,f);
	}

	public static long Fib(int N, long[] f) {
		if (f[N] == 0) {
			if (N == 1) {
				f[N] = 1;
			}
			else if (N > 1) {
				f[N] = Fib(N - 1, f) + Fib(N - 2, f);
			}
		}
		
		return f[N];
	}

	public static void main( String[] args) {
		for (int N = 0; N < 50; N++)
            StdOut.println(N + " " + Fib(N));
	}
	
}
