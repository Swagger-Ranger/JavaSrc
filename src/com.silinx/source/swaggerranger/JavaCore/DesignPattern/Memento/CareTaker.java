package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Memento;

/**
 * 负责管理备忘录对象，也就是备份的操作在具体的源发类中实现，但源发类并不保存备份的结果，结果在此类保存
 * 负责去保存对象的备份，单个对象就可以直接使用一个使用属性来保存，
 * 这里可以使用一个栈（先进后出）来保存备份对象以实现回滚
 */
public class CareTaker {
	
	private EmpMemento memento;

//	private List<EmpMemento> list = new ArrayList<EmpMemento>();
	
	
	
	public EmpMemento getMemento() {
		return memento;
	}

	public void setMemento(EmpMemento memento) {
		this.memento = memento;
	}
	
	
	
	
}
