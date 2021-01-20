package com.silinx.source.swaggerranger.JavaCore.DesignPattern.FlyWeight;

/**
 * 享元类
 * 享元类接口
 *
 */
public interface ChessFlyWeight {

	void setColor( String c );
	String getColor();
	void display( Coordinate c );
}

/**
 * 享元接口的实现类，将需要共享的属性作为内部私有属性--这里就是color
 * 然后将不共享的属性作为单独的类传入其对象--这里就是Coordinate c
 */
class ConcreteChess implements ChessFlyWeight {

	private String color;

	public ConcreteChess( String color) {
		super();
		this.color = color;
	}

	@Override
	public void display(Coordinate c) {
		System.out.println("棋子颜色："+color);
		System.out.println("棋子位置："+c.getX()+"----"+c.getY());
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void setColor( String c) {
		this.color = c;
	}
	
}
