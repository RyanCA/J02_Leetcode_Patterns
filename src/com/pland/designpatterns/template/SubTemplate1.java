package com.pland.designpatterns.template;

public class SubTemplate1 extends Template{
	
	public void method2(){
		System.out.println("method2 from SubTemplate1");
	}

	public static void main(String args[]){
		new SubTemplate1().templateMethod();
	}
}
