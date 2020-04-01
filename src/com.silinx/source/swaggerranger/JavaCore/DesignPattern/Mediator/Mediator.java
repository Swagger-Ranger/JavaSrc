package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Mediator;

public interface Mediator {
	
	void register( String dname, Department d );
	
	void command( String dname );
	
}
