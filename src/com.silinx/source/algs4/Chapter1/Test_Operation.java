package com.silinx.source.algs4.Chapter1;

public class Test_Operation {

	static int a =5;
	static void valuePass(int x)
	{
		x +=1;
		System.out.println(x);
	}


	public class  TestClass{

	}



	public static void main( String[] args)
	{
//		valuePass(a);
//		System.out.println(a);
//		Test t = new Test();
//		t.test();
//		String str = "1234";
//		System.out.println(Integer.parseInt(str));
		String dir= System.getProperty("user.dir");
		System.out.println(dir);
	}
}

class Test{
	public static void test(){
		System.out.println("This is a class that is out of box but not public!!!");
	}

	private static  int nextID = 1;

	public void setID(){
		int id = nextID;
		nextID ++;

	}

}