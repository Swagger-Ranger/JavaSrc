package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Strategy;

public class OldCustomerManyStrategy implements Strategy {

	@Override
	public double getPrice(double standardPrice) {
		System.out.println("打八折");
		return standardPrice*0.8;
	}

}
