package com.silinx.source.swaggerranger.JavaCore.classLoader.classloader;

import com.silinx.source.swaggerranger.JavaCore.classLoader.com.example.Sample;

import java.lang.reflect.Method;


public class ClassIdentity {

	public static void main(String[] args) {
		new ClassIdentity().testClassIdentity();
	}
	
	public void testClassIdentity() {
		//这里是class文件的路径
		String classDataRootPath = "D:\\Swagger-Ranger\\git-workspace\\JavaSrc\\resources";
//		String classDataRootPath = "D:\\Swagger-Ranger\\git-workspace\\JavaSrc\\resources";
		FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
		FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
		System.out.println(fscl1.getParent());
		String className = "Sample";
		try {
			/**
			 * 自定义一个类加载器，只需要重写findClass方法，然后仍然调用双亲委派，当父类无法加载时就会调用加载器的findClass方法，
			 * 而这里调用父类加载器会无法找到class文件，因为这个路径的class文件不在默认的classpath下面，所以父类加载器无法找到对于的class加载文件
			 * 进而调用findClass，然后FileSystemClassLoader会去读取文件字节流调用defineClass来将class字节码加载到jvm中
			 */
			Class<?> class1 = fscl1.loadClass(className);
//			Class<?> class1 = fscl1.findClass(className);
			Object obj1 = class1.newInstance();
			Class<?> class2 = fscl2.loadClass(className);
//			Class<?> class2 = fscl2.findClass(className);
			Object obj2 = class2.newInstance();

			//使用自定义的类加载器加载的进而和系统类加载器加载的class不是相同的
			System.out.println(obj1 instanceof Sample);
			System.out.println(obj2 instanceof Sample);
			Method setSampleMethod = class1.getMethod("setSample", Object.class);
			setSampleMethod.invoke(obj1, obj2);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
