package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Proxy.JDK_Proxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main( String[] args) {
		
		Star realStar = new RealStar();
		StarHandler handler = new StarHandler(realStar);

		/**
		 * 这里生成Proxy的实例，这是最关键的，需要传入3个参数：
		 * 1.类加载器ClassLoader.getSystemClassLoader()这里是直接调用的系统加载类
		 * 2.需要动态代理类对应实现的接口
		 * 3.InvocationHandler 接口的实现类，在InvocationHandler接口的实现类中定义需要如何调用
		 */
		Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[]{Star.class}, handler);
		proxy.sing();
		
	}	
}