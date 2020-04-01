package com.silinx.source.swaggerranger.JavaCore.DesignPattern.State;


/**
 * 房间对象-- 切换不同的状态，此对象持有不同的状态即其是由属性State
 * @author Administrator
 *
 */
public class HomeContext {
	//如果是银行系统，这个Context类就是账号。根据金额不同，切换不同的状态！
	private State state;
	
	
	public void setState(State s){
		System.out.println("修改状态！");
		state = s;
		state.handle();
	}
	
}
