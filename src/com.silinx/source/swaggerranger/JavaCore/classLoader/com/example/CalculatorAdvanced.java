package com.silinx.source.swaggerranger.JavaCore.classLoader.com.example;


import com.silinx.source.swaggerranger.JavaCore.classLoader.classloader.ICalculator;

public class CalculatorAdvanced implements ICalculator {

	public String calculate(String expression) {
		return "Result is " + expression;
	}

	public String getVersion() {
		return "2.0";
	}

}
