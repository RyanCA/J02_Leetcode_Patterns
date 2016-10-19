package com.pland.designpatterns.template;

public class Test {
	
	public static void main(String args[]){
		Game a = new Cricket();
		Game b = new Football();
		a.play();
		b.play();
	}

}
