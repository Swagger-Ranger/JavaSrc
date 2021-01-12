package com.silinx.source.swaggerranger.JavaCore.DesignPattern.FlyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 * 享元工厂类是享元模式的一个关键点，工厂来生成每个不同的共享对象
 *
 *
 */
public class ChessFlyWeightFactory {
	//享元池
	private static Map<String,ChessFlyWeight> map = new HashMap<String, ChessFlyWeight>();
	
	public static ChessFlyWeight  getChess( String color){
		
		if(map.get(color)!=null){
			return map.get(color);
		}else{
			ChessFlyWeight cfw = new ConcreteChess(color);
			map.put(color, cfw);
			return cfw;
		}
		
	}
	
	
}
