package com.pland.designpatterns.template;

public abstract class Template {
	

	
	public void templateMethod(){
		method1();
		method2();
		method3();
	}
	
	public void method1(){
		;
	}
	
	public abstract void method2();
	
	public void method3(){
		;
	}
	


}
