package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Strategy;

public class Client {
	public static void main( String[] args) {
		
		Strategy s1 = new OldCustomerManyStrategy();
		Context ctx = new Context(s1);
		
		ctx.pringPrice(998);
		
	}
}
