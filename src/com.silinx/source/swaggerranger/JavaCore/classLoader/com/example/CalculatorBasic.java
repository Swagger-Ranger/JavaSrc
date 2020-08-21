package com.silinx.source.swaggerranger.JavaCore.classLoader.com.example;


import com.silinx.source.swaggerranger.JavaCore.classLoader.classloader.ICalculator;

public class CalculatorBasic implements ICalculator {

	public String calculate(String expression) {
		return expression;
	}

	public String getVersion() {
		return "1.0";
	}

}
