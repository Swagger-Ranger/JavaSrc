package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Proxy.JDK_Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 这个就是代理实例需要实现的操作
 */
public class StarHandler implements InvocationHandler {
	
//	Star realStar;
	Object realStar;

//	public StarHandler(Star realStar) {
	public StarHandler( Object realStar) {
		super();
		this.realStar = realStar;
	}

	/**
	 * 此方法实现代理的最终调用方法，也就是Proxy动态代理生成的代理类，
	 * 最终的方法调用实际都是调用InvocationHandler接口实现类的invoke()方法
	 *
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke( Object proxy, Method method, Object[] args ) throws InvocationTargetException, IllegalAccessException {

		Object object = null;

		//这里可以在对方法实际执行前作自定义操作
		System.out.println("真正的方法执行前！");
		System.out.println("面谈，签合同，预付款，订机票");

		//这里调用真正的方法，即传入的实际执行的类
		if (method.getName().equals("sing")) {
			//这里是使用了reflect包中的Method类的invoke方法，由Method对象method来在realStar对象上调用args
			//比如Proxy实例调用方法m，args就是m，然后在此method调用realStar的对应m方法
			object = method.invoke(realStar, args);
		}

		System.out.println("真正的方法执行后！");
		System.out.println("收尾款");
		return object;
	}

}
