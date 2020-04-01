package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Observer;

public class ObserverA implements Observer {

	private int myState;   //myState需要跟目标对象的state值保持一致！


	/**
	 * 观察者模式的关键，提供一个聚合目标对象的更新状态的公共方法，当具体的目标对象更新时会调用此方法来更新观察者状态
	 * @param subject
	 */
	@Override
	public void update(Subject subject) {
		myState = ((ConcreteSubject)subject).getState();
	}


	public int getMyState() {
		return myState;
	}
	public void setMyState(int myState) {
		this.myState = myState;
	}
	
	

}
