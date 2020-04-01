package com.silinx.source.swaggerranger.JavaCore.DesignPattern.FlyWeight;

/**
 * 测试类，这里每个的chess即模拟围棋棋子当颜色相同时都是使用的相同对象，而不同的位置只是其不同的调用方法不同
 */
public class Client {
	public static void main( String[] args) {
		ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
		ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");
		System.out.println(chess1);
		System.out.println(chess2);
		
		System.out.println("增加外部状态的处理===========");
		chess1.display(new Coordinate(10, 10));
		chess2.display(new Coordinate(20, 20));
		
		
	}
}
