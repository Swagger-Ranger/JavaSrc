package com.silinx.source.optimizingJava.jmh;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
public class HugeMethod {

	private java.util.Random r = new java.util.Random();

	@Benchmark
	public long moreThan8000()
	{
		return r.nextInt() +
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt();
	}

	@Benchmark
	public long lessThan8000()
	{
		return r.nextInt() +
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+
	r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt()+r.nextInt();
	}
}
