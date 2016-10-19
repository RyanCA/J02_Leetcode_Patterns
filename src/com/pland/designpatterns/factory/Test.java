package com.pland.designpatterns.factory;

/**
 * https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 *
 */
public class Test {
	
	public static void main(String args[]){
		Shape a = ShapeFactory.getShape("Circle");
		a.draw();
		
		Shape b = ShapeFactory.getShape("Rectangle");
		b.draw();
	}

}
